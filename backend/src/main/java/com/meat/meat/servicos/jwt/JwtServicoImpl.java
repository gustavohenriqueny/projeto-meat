package com.meat.meat.servicos.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

@Service
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtServicoImpl implements JwtServico {

    @Value("${aplicacao.seguranca.jwt.chave-secreta}")
    private String chaveSecreta;

    @Value("${aplicacao.seguranca.jwt.expiracao-chave}")
    private Long expiracaoChave;

    @Override
    public String extrairUsuario(String token) {
        return extrairClaim(token, Claims::getSubject);
    }

    private <T> T extrairClaim(String token, Function<Claims, T> claimsResolver) {
        Claims claims = extrairTodosClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extrairTodosClaims(String token) {
        return Jwts.parserBuilder()
            .setSigningKey(getSigningKey())
            .build()
            .parseClaimsJws(token)
            .getBody();
    }

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(this.chaveSecreta);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    @Override
    public Boolean isTokenValido(String token, String email) {
        String emailToken = extrairUsuario(token);
        return (emailToken.equals(email)) && !isTokenExpirado(token);
    }

    private boolean isTokenExpirado(String token) {
        return extrairClaim(token, Claims::getExpiration).before(new Date());
    }

    @Override
    public String gerarToken(String email) {
        return gerarToken(new HashMap<>(), email);
    }

    public String gerarToken(Map<String, Objects> claimsExtraidos, String email) {
        return Jwts.builder()
            .setClaims(claimsExtraidos)
            .setSubject(email)
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + expiracaoChave))
            .signWith(getSigningKey(), SignatureAlgorithm.HS256)
            .compact();
    }
}
