package com.meat.meat.configuracoes;

import com.meat.meat.filtros.FiltroAutenticacaoJwt;
import com.meat.meat.filtros.FiltroCors;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class ConfiguracaoSeguranca {

    private final FiltroAutenticacaoJwt filtroAutenticacaoJwt;
    private final AuthenticationProvider authenticationProvider;
    private final FiltroCors filtroCors;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(
                authz -> authz.requestMatchers("/api/autenticacao/**")
                    .permitAll()
                    .anyRequest()
                    .authenticated())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authenticationProvider(authenticationProvider)
            .addFilterBefore(filtroCors, UsernamePasswordAuthenticationFilter.class)
            .addFilterBefore(filtroAutenticacaoJwt, UsernamePasswordAuthenticationFilter.class).build();
    }

}
