package com.meat.meat.servicos.autenticacao;

import com.meat.meat.entidades.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
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
public class JwtServico {

    @Value("${aplicacao.seguranca.jwt.chave-secreta}")
    private String chaveSecreta;

    @Value("${aplicacao.seguranca.jwt.expiracao-chave}")
    private Long expiracaoChave;

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

    public boolean isTokenValido(String token, String emailUsuario) {
        String emailToken = extrairUsuario(token);
        return (emailToken.equals(emailUsuario)) && !isTokenExpirado(token);
    }

    private boolean isTokenExpirado(String token) {
        return extrairClaim(token, Claims::getExpiration).before(new Date());
    }

    public String gerarToken(Usuario usuario) {
        return gerarToken(new HashMap<>(), usuario);
    }

    public String gerarToken(Map<String, Objects> claimsExtraidos, Usuario usuario) {
        return Jwts.builder()
                .setClaims(claimsExtraidos)
                .setSubject(usuario.getEmail())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiracaoChave))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }
}
