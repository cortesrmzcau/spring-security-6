package org.cortesrmzcau.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.cortesrmzcau.models.entity.CustomerEntity;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
    public static final String JWT_SECRET = "jxgEQe.XHuPq8VdbyYFNkAN.dudQ0903YUn4";

    private Claims getAllClaimsFromToken(String token) {
        final var key = Keys.hmacShaKeyFor(JWT_SECRET.getBytes(StandardCharsets.UTF_8));
        return Jwts
                .parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public <T> T getClaimsFromToken(String token, Function<Claims, T> claimsResolver) {
        final var claims = this.getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }
    
    private Date getDateExpirationToken (String token) {
        return this.getClaimsFromToken(token, Claims::getExpiration);
    }

    private Boolean isTokenExpired(String token) {
        final var expirationDate = this.getDateExpirationToken(token);
        return expirationDate.before(new Date());
    }
}
