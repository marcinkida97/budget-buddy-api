package com.budgetbuddy.budget_buddy.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BudgetConstraintResponse {

    private UUID budgetConstraintId;
    private UUID budgetId;
    private boolean isPrimary;
}
