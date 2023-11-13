package com.budgetbuddy.budget_buddy.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Getter
@Entity
@Table(name = "budget_entity")
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

    @Column(name = "budgetId")
    @NonNull
    private UUID budgetId;   //foreign key of Budgets.id

}
