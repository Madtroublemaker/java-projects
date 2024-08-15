package org.example.expensetracker.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.expensetracker.dto.TokenUser;
import org.example.expensetracker.service.TokenService;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class TokenFilter extends OncePerRequestFilter {

    private final static String SUFFIX = "Bearer ";

    private final TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);

        TokenUser user = null;

        if (token != null) {
            user = tokenService.verifyToken(token.replaceFirst(SUFFIX, ""));
        }

        if (user != null) {
            processUser(user);
            filterChain.doFilter(request, response);
            return;
        }

        response.setStatus(401);
    }

    private void processUser(TokenUser tokenUser) {
        SecurityContextHolder.getContext().setAuthentication(tokenUser);
    }
}
