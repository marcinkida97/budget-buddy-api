package com.budgetbuddy.budget_buddy.responses;

import com.budgetbuddy.budget_buddy.models.BudgetEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BudgetEntitiesListResponse {

    private List<BudgetEntity> budgetEntitiesList;
}
