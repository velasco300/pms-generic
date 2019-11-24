package com.zzz.pms.pmsgeneric.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class JwtUtils {

    private static final String SECRET_KEY = "dfdfd";

    public static String createToken(int minute, Map<String, String> payload) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
        JWTCreator.Builder builder = JWT.create().withExpiresAt(from(minute));
        payload.forEach((k, v) -> builder.withClaim(k, v));
        return builder.sign(algorithm);
    }

    /**
     * 1:成功，2：过期，3：非法token
     */
    public static int verifyToken(String token) {
        int status = 1;
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
        try {
            JWT.require(algorithm).build().verify(token);
        } catch (TokenExpiredException e) {
            status = 2;
        } catch (Exception e) {
            status = 3;
        }
        return status;
    }

    public static String getPayload(String token, String key) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim(key).asString();
    }

    private static Date from(int m) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MINUTE, m);
        return c.getTime();
    }


}
