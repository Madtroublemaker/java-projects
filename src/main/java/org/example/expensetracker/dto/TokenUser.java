package org.example.expensetracker.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.expensetracker.enums.Role;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenUser implements Authentication {
    private Long id;
    private String username;
    private String role;

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(Role.valueOf(role));
    }

    @Override
    @JsonIgnore
    public Object getCredentials() {
        return null;
    }

    @Override
    @JsonIgnore
    public Object getDetails() {
        return username;
    }

    @Override
    @JsonIgnore
    public Object getPrincipal() {
        return id;
    }

    @Override
    @JsonIgnore
    public boolean isAuthenticated() {
        return true;
    }

    @Override
    @JsonIgnore
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

    }

    @Override
    public String getName() {
        return username;
    }
}
