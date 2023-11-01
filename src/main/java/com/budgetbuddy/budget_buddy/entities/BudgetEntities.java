package com.budgetbuddy.budget_buddy.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name = "budget_buddy")
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BudgetEntities {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private static UUID id;

    @Column(name = "amount")
    private static float amount;

    @Column(name = "currency")
    private static String currency;

    @Column(name = "category")
    private static String category;

    @Column(name = "budgetId")
    private static UUID budgetId;   //foreign key of Budgets.id
}
