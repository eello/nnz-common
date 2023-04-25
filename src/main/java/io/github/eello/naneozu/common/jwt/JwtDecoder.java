package io.github.eello.naneozu.common.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Map;

public class JwtDecoder {

    public static Map<String, Claim> getClaims(String jwt) {
        return decode(jwt).getClaims();
    }

    public static String getClaimByName(String jwt, String name) {
        return decode(jwt).getClaim(name).asString();
    }

    private static DecodedJWT decode(String jwt) {
        return JWT.decode(jwt);
    }
}
