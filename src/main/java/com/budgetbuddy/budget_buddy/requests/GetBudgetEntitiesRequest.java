package com.budgetbuddy.budget_buddy.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetBudgetEntitiesRequest {

    private List<UUID> budgetEntitiesIds;
}
