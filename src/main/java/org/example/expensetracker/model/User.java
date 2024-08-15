package org.example.expensetracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.expensetracker.enums.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "app_user")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String password;
    private String username;

    @OneToMany(mappedBy = "user")
    private List<Expense> expenses;

    @OneToMany(mappedBy = "user")
    private List<Income> incomes;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(role);
    }
}
