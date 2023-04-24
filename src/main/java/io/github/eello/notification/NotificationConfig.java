package io.github.eello.notification;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableConfigurationProperties(MattermostProperties.class)
public class NotificationConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    @ConditionalOnMissingBean
    public MattermostSender mattermostSender(MattermostProperties mattermostProperties) {
        return new MattermostSender(restTemplate(), mattermostProperties);
    }

    @Bean
    @ConditionalOnMissingBean
    public NotificationManager notificationManager(MattermostProperties mattermostProperties) {
        return new NotificationManager(mattermostSender(mattermostProperties));
    }
}
