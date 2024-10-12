package com.example.green_room.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ClaimsMutator;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.crypto.SecretKey;

@Component
public class JwtHelper {

    @Value("${jwt.privateKey}")
    private String privateKey;

    public String generateToken(String data){

        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privateKey));
        String jws = Jwts.builder().subject(data).signWith(key).compact();
        return jws;

    }

    public Claims getIdFromJwtToken(String jwt){

        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privateKey));
        jwt =jwt.substring(7);
        return Jwts.parser().verifyWith(key).build().parseSignedClaims(jwt).getPayload();
    }

    public boolean verifyToken(String token){
        try{
            SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privateKey));
            Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token);
            return true;
        } catch(Exception e){
            return false;
        }

    }

}
