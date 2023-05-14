package io.github.eello.nnz.common.config;

import io.github.eello.nnz.common.jwt.DecodedToken;
import io.github.eello.nnz.common.jwt.JwtDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Optional;

@Configuration
@EnableJpaAuditing
public class JpaAuditingAutoConfigure implements AuditorAware<Long> {

    private final HttpServletRequest request;

    public JpaAuditingAutoConfigure(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public Optional<Long> getCurrentAuditor() {
        String authorization = request.getHeader("Authorization");
        if (StringUtils.hasText(authorization) && authorization.startsWith("Bearer ")) {
            String jwt = authorization.substring(7);
            try {
                DecodedToken token = JwtDecoder.decode(jwt);
                return Optional.of(token.getId());
            } catch (UnsupportedEncodingException e) {
                return Optional.empty();
            }
        }

        return Optional.empty();
    }
}
