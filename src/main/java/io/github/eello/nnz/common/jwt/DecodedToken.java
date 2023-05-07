package io.github.eello.nnz.common.jwt;

public class DecodedToken {

    private Long id;
    private String email;
    private String authProvider;

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

    @Override
    public String toString() {
        return "DecodedToken{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", authProvider='" + authProvider + '\'' +
                '}';
    }
}
