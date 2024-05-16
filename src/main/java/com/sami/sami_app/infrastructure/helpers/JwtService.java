package com.sami.sami_app.infrastructure.helpers;

import com.sami.sami_app.domain.entities.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import io.jsonwebtoken.io.Decoders;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtService {
    // Clave o firma
    private final String SECRET_KEY = "U0FNSV9TRVJWSUNJT19BTUJVTEFUT1JJT19NRURJQ09fSU5NRURJQVRPIExhIE1lam9yIE9wY2lvbiBQYXJhIFNhbHZhciBUdSBWaWRhLi4uLmNsYXZlIHNlY3JldA==";

    // Encriptar clave secreta
    public SecretKey getKey () {
        // Convertir a bityes
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        // return llave cifrada
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // constuir JWT
    public String getToken(Map <String, Object> claims, User user) {
        return Jwts.builder()
                .claims(claims) // cuerpo jwt
                .subject(user.getFirstName()) // de quien es el JWT
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .signWith(this.getKey()) // firma token
                .compact();
    }

    public String getToken (User user) {
        // map
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", user.getId());
        claims.put("role", user.getRole().name());

        return getToken(claims, user);
    }
}
