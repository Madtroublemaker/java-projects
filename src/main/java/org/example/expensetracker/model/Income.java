package org.example.expensetracker.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.*;
import org.example.expensetracker.enums.IncomeCategory;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Double amount;
    @Enumerated(EnumType.STRING)
    private IncomeCategory incomeCategory;
    private LocalDate createdDate;

    @ManyToOne
    @JoinColumn(name ="user_id")
    private User user;
}
