package com.isicod.net.springCas.security.constants;

public class SecurityConstants {
    public static final String SECRET_KEY = "bQeThWmZq4t7w!z$C&F)J@NcRfUjXn2r5u8x/A?D*G-KaPdSgVkYp3s6v9y$B&E)"; //Your secret should always be strong (uppercase, lowercase, numbers, symbols) so that nobody can potentially decode the signature.
    public static final int TOKEN_EXPIRATION = Integer.MAX_VALUE; // approx 25 days.
    public static final String BEARER = "Bearer "; // Authorization : "Bearer " + Token 
    public static final String AUTHORIZATION = "Authorization"; // "Authorization" : Bearer Token
    public static final String REQUEST_JWT = "/api/v1/auth/jwt"; // Public path that clients can use to request jwt.
}
