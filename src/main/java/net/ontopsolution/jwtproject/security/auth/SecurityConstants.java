package net.ontopsolution.jwtproject.security.auth;

public class SecurityConstants {

    public static final String SECRET = "TokenSecretoGeneradoGlobantBancoMacroAr!#$%&";
    public static final String ENCODED = "VG9rZW5TZWNyZXRvR2VuZXJhZG9HbG9iYW50QmFuY29NYWNyb0FyJSYK";
    public static final long EXPIRATION_TIME = 3_600_000;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}
