package io.github.eello.nnz.common.config;

import io.github.eello.nnz.common.controller.ControllerAdvisor;
import io.github.eello.nnz.common.logger.LoggingAspect;
import io.github.eello.nnz.common.notification.MattermostProperties;
import io.github.eello.nnz.common.notification.MattermostSender;
import io.github.eello.nnz.common.notification.NotificationManager;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableAspectJAutoProxy
@EnableJpaAuditing
@EnableConfigurationProperties(MattermostProperties.class)
public class AutoConfigure {

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

    @Bean
    @ConditionalOnMissingBean(annotation = RestControllerAdvice.class)
    public ControllerAdvisor controllerAdvisor(MattermostProperties mattermostProperties) {
        return new ControllerAdvisor(notificationManager(mattermostProperties));
    }

    @Bean
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }
}
