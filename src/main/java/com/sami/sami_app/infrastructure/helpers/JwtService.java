package com.sami.sami_app.infrastructure.helpers;


import com.sami.sami_app.domain.entities.Account;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import io.jsonwebtoken.io.Decoders;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtService {
    // key or signature
    private final String SECRET_KEY = "RVNUQSBDTEFWRSBFUyBHRU5FUkFEQSBQQVJBIExBIEZJUk1BIERFIExBUyBDVUVOVEFTIERFIFNBTUkgKi8t";

    // Encript Secret Key
    public SecretKey getKey () {
        //  Encrypt secret key
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        // return encrypted key
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // Build JWT
    public String getToken(Map <String, Object> claims, Account account) {
        return Jwts.builder()
                .claims(claims) // JWT body 
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .signWith(this.getKey()) // signature token
                .compact();
    }

    public String getToken (Account account) {
        // map
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", account.getId());
        claims.put("role", account.getRole().name());

        return getToken(claims, account);
    }


    /*OBTAIN ALL CLAIMS*/
    public Claims getAllClaims (String token) {
        return Jwts
                .parser()
                .verifyWith(this.getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public <T> T getClaim (String token, Function<Claims, T> claimsResolver) {
        final  Claims claims = this.getAllClaims(token);
        return claimsResolver.apply(claims);
    }


    public String getUserEmailFromToken(String token) {
        return this.getClaim(token, Claims::getSubject);
    }

    public Date getExpiration (String token) {
        return this.getClaim(token, Claims::getExpiration);
    }

    public boolean isTokenExpired(String token) {
        return this.getExpiration(token).before(new Date());
    }

    public boolean isTokenIsValid (String token, UserDetails userDetails) {
        String userEmail = this.getUserEmailFromToken(token);

        return (userEmail.equals(userDetails.getUsername()) && !this.isTokenExpired(token));
    }
}
