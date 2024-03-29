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
public class BudgetResponse {

    private UUID budgetId;
    private String name;
    private String description;
    private Set<UUID> budgetEntitiesIds;
    private Set<UUID> budgetUsersIds;
    private boolean isPrimary;
}
