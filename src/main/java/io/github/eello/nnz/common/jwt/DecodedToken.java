package io.github.eello.nnz.common.jwt;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class DecodedToken {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss");

    private Long id;
    private String email;
    private String authProvider;
    private String role;
    private Long exp;

    public DecodedToken(Long id, String email, String authProvider) {
        this.id = id;
        this.email = email;
        this.authProvider = authProvider;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getAuthProvider() {
        return authProvider;
    }

    public String getRole() {
        return role;
    }

    public Long getExp() {
        return exp;
    }

    public Date getExpDate() {
        return new Date(exp * 1000L);
    }

    @Override
    public String toString() {
        return "DecodedToken{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", authProvider='" + authProvider + '\'' +
                ", role='" + role + '\'' +
                ", exp=" + simpleDateFormat.format(getExpDate()) +
                '}';
    }
}
