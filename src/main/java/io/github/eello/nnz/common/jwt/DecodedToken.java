package io.github.eello.nnz.common.jwt;

public class DecodedToken {

    private Long id;
    private String email;

    public DecodedToken(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "DecodedToken{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}
