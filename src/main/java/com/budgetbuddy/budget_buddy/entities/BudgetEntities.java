package com.budgetbuddy.budget_buddy.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BudgetEntities {

    private static UUID id;

    private static float amount;

    private static String currency;

    private static String category;

    private static UUID budgetId;   //foreign key of Budgets.id
}
