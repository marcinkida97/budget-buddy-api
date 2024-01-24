package com.budgetbuddy.budget_buddy.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BudgetEntityRequest {

    private UUID budgetId;
    private float amount;
    private String type;
    private String category;
    private Date date;
}
