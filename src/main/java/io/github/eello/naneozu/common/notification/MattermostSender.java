package io.github.eello.naneozu.common.notification;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;


public class MattermostSender {
    @Value("${notification.mattermost.enabled}")
    private boolean mmEnabled;
    @Value("${notification.mattermost.webhook-url}")
    private String webhookUrl;

    private final RestTemplate restTemplate;
    private final MattermostProperties mmProperties;

    public MattermostSender(RestTemplate restTemplate, MattermostProperties mmProperties) {
        this.restTemplate = restTemplate;
        this.mmProperties = mmProperties;
    }

    public void sendMessage(Exception exception, String uri, String params) {
        if (!mmEnabled)
            return;

        try {
            MattermostMessageDTO.Attachment attachment = MattermostMessageDTO.Attachment.builder()
                    .channel(mmProperties.getChannel())
                    .author_icon(mmProperties.getAuthorIcon())
                    .author_name(mmProperties.getAuthorName())
                    .color(mmProperties.getColor())
                    .pretext(mmProperties.getPretext())
                    .title(mmProperties.getTitle())
                    .text(mmProperties.getText())
                    .footer(mmProperties.getFooter())
                    .build();

            attachment.addExceptionInfo(exception, uri, params);
            MattermostMessageDTO.Attachments attachments = new MattermostMessageDTO.Attachments(attachment);
            attachments.addProps(exception);

            String payload = new Gson().toJson(attachments);

            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-type", MediaType.APPLICATION_JSON_VALUE);

            HttpEntity<String> entity = new HttpEntity<>(payload, headers);
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.postForEntity(webhookUrl, entity, String.class);

        } catch (Exception e) {
//            log.error("#### ERROR!! Notification Manager : {}", e.getMessage());
        }

    }
}
