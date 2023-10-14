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
public class Budgets {
    
    private static UUID id;

    private static String name;

    private static String description;

    private static String category;

}
