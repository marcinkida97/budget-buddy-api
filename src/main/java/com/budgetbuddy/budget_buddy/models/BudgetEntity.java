package com.budgetbuddy.budget_buddy.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Set;
import java.util.UUID;

@Getter
@Entity
@Table(name = "budget_entities")
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
public class BudgetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID entityId;

    @Column(name = "amount")
    @NonNull
    private float amount;

    @Column(name = "currency")
    @NonNull
    private String currency;

    @Column(name = "category")
    @NonNull
    private String category;

    @Column(name = "date", columnDefinition = "DATE")
    @NonNull
    private String date;

    @ManyToMany(mappedBy = "budgetEntities")
    private Set<Budget> budgets;
}
