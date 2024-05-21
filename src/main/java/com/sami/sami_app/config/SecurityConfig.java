package com.sami.sami_app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.sami.sami_app.infrastructure.helpers.JwtAuthenticationFilter;
import com.sami.sami_app.util.enums.Role;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity // Activar spring security en esta clase
@AllArgsConstructor
public class SecurityConfig {

        @Autowired
        private final AuthenticationProvider authenticationProvider;

        @Autowired
        private final JwtAuthenticationFilter authenticationFilter;

        // Crear rutas publicas
        private final String[] PUBLIC_RESOURCES = { "/auth/**" };
        private final String[] ADMIN_RESOURCES = { "/admin/**" };
        private final String[] AMBULANCE_RESOURCES = { "/ambulance/**" };
        private final String[] CLIENT_RESOURCES = { "/service/**", "/service" };

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

                return http
                                .csrf(csrf -> csrf.disable()) // Deshabilitar protección csrf -> Stateless
                                .authorizeHttpRequests(authRequest -> authRequest
                                                .requestMatchers(ADMIN_RESOURCES).hasAuthority(Role.ADMIN.name())
                                                .requestMatchers(CLIENT_RESOURCES).hasAuthority(Role.CLIENT.name())
                                                .requestMatchers(AMBULANCE_RESOURCES)
                                                .hasAnyAuthority(Role.DRIVER.name(), Role.EMT.name())
                                                .requestMatchers(PUBLIC_RESOURCES).permitAll()
                                                .anyRequest().authenticated())
                                .sessionManagement(
                                                sessionManager -> sessionManager
                                                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                                // Agregar el proveedor de autenticación
                                .authenticationProvider(authenticationProvider)
                                // Agregar el filtro personalizado antes del filtro de spring security
                                .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
                                .build();
        }
}
