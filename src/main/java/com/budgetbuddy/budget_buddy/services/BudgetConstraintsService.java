package com.budgetbuddy.budget_buddy.services;

import com.budgetbuddy.budget_buddy.models.BudgetConstraints;
import com.budgetbuddy.budget_buddy.repositories.BudgetConstraintsRepository;
import com.budgetbuddy.budget_buddy.responses.BudgetConstraintResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BudgetConstraintsService {

    private final BudgetConstraintsRepository budgetConstraintsRepository;

    public BudgetConstraintResponse createBudgetConstraint() {
        var budgetConstraint = BudgetConstraints.builder()
                .isPrimary(true)
                .build();

        var savedBudgetConstraint = budgetConstraintsRepository.save(budgetConstraint);

        return BudgetConstraintResponse.builder()
                .budgetConstraintId(savedBudgetConstraint.getBudgetConstraintId())
                .isPrimary(savedBudgetConstraint.isPrimary())
                .build();
    }

    public BudgetConstraintResponse getBudgetConstraintById(UUID budgetConstraintId) {
        var budgetConstraintResponse = budgetConstraintsRepository.findByBudgetConstraintId(budgetConstraintId);

        if (budgetConstraintResponse.isPresent()) {
            var budgetConstraint = budgetConstraintResponse.get();

            return BudgetConstraintResponse.builder()
                    .budgetId(budgetConstraint.getBudgetId())
                    .isPrimary(budgetConstraint.isPrimary())
                    .build();

        } else {
            throw new IllegalArgumentException("Budget not found for id: " + budgetConstraintId);
        }
    }
}
