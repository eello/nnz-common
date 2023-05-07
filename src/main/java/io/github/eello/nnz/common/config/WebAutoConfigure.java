package io.github.eello.nnz.common.config;

import io.github.eello.nnz.common.controller.JwtTokenDecodeResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebAutoConfigure implements WebMvcConfigurer {

    @Bean
    public JwtTokenDecodeResolver jwtTokenDecodeResolver() {
        return new JwtTokenDecodeResolver();
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(jwtTokenDecodeResolver());
    }
}
