package org.example.expensetracker.config;

import lombok.RequiredArgsConstructor;
import org.example.expensetracker.filter.TokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final UserDetailsService userDetailsService;
    private final TokenFilter tokenFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .userDetailsService(userDetailsService)
                .addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(config -> {
                    config.requestMatchers("/auth/*").permitAll();
                    config.anyRequest().authenticated();
                }).build();
    }

}
