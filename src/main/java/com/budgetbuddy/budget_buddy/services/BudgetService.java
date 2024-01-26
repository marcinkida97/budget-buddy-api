package com.budgetbuddy.budget_buddy.services;

import com.budgetbuddy.budget_buddy.models.Budget;
import com.budgetbuddy.budget_buddy.repositories.BudgetConstraintsRepository;
import com.budgetbuddy.budget_buddy.repositories.BudgetRepository;
import com.budgetbuddy.budget_buddy.responses.BudgetResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BudgetService {

    private final BudgetRepository budgetRepository;
    private final BudgetConstraintsRepository budgetConstraintsRepository;
    private final BudgetConstraintsService budgetConstraintsService;

    public BudgetResponse createBudget() {
        var budgetConstraint = budgetConstraintsService.createBudgetConstraint();

        var budget = Budget.builder()
                .name("My budget")
                .description("My primary budget")
                .budgetConstraintsId(budgetConstraint.getBudgetConstraintId())
                .budgetUsersIds(new HashSet<>())
                .build();

        var savedBudget = budgetRepository.save(budget);

        return BudgetResponse.builder()
                .budgetId(savedBudget.getBudgetId())
                .name(savedBudget.getName())
                .description(savedBudget.getDescription())
                .budgetEntitiesIds(savedBudget.getBudgetEntitiesIds())
                .budgetUsersIds(savedBudget.getBudgetUsersIds())
                .isPrimary(budgetConstraint.isPrimary())
                .build();
    }

    public BudgetResponse getBudgetById(UUID budgetId) {
        var budgetOptional = budgetRepository.findByBudgetId(budgetId);


        if (budgetOptional.isPresent()) {
            var budget = budgetOptional.get();
            var budgetConstraintOptional = budgetConstraintsRepository.findByBudgetConstraintId(budget.getBudgetConstraintsId());

            if (budgetConstraintOptional.isPresent()) {
                var budgetConstraint = budgetConstraintOptional.get();

                return BudgetResponse.builder()
                        .budgetId(budget.getBudgetId())
                        .name(budget.getName())
                        .description(budget.getDescription())
                        .budgetEntitiesIds(budget.getBudgetEntitiesIds())
                        .budgetUsersIds(budget.getBudgetUsersIds())
                        .isPrimary(budgetConstraint.isPrimary())
                        .build();
            } else {
                throw new IllegalArgumentException("Budget constraint not found for id: " + budget.getBudgetConstraintsId());
            }
        } else {
            throw new IllegalArgumentException("Budget not found for id: " + budgetId);
        }
    }
}
