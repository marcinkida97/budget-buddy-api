package com.budgetbuddy.budget_buddy.responses;

import com.budgetbuddy.budget_buddy.models.Budget;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

    private String token;
    private String firstname;
    private String lastname;
    private Set<Budget> budgets;
}
