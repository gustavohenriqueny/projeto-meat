package com.meat.meat.configuracoes.filtros;

import com.meat.meat.servicos.autenticacao.JwtServico;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class FiltroAutenticacaoJwt extends OncePerRequestFilter {

    private final JwtServico jwtServico;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        String cabecalhoAutenticacao = request.getHeader("Authorization");
        String token;
        String emailUsuario;
        if (cabecalhoAutenticacao == null || !cabecalhoAutenticacao.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        token = cabecalhoAutenticacao.substring(7);
        emailUsuario = jwtServico.extrairUsuario(token);
        if (emailUsuario != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(emailUsuario);
            if (jwtServico.isTokenValido(token, emailUsuario)) {
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities()
                );
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request, response);
    }

}
