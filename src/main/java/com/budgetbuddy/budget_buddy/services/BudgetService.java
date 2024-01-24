package com.budgetbuddy.budget_buddy.services;

import com.budgetbuddy.budget_buddy.models.Budget;
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

    public BudgetResponse createBudget() {
        var budget = Budget.builder()
                .name("Primary")
                .description("My budget")
                .budgetUsersIds(new HashSet<>())
                .build();

        var savedBudget = budgetRepository.save(budget);

        return BudgetResponse.builder()
                .budgetId(savedBudget.getBudgetId())
                .name(savedBudget.getName())
                .description(savedBudget.getDescription())
                .budgetEntitiesIds(savedBudget.getBudgetEntitiesIds())
                .budgetUsersIds(savedBudget.getBudgetUsersIds())
                .build();
    }

    public BudgetResponse getBudgetById(UUID budgetId) {
        var budgetOptional = budgetRepository.findByBudgetId(budgetId);

        if (budgetOptional.isPresent()) {
            var budget = budgetOptional.get();

            return BudgetResponse.builder()
                    .budgetId(budget.getBudgetId())
                    .name(budget.getName())
                    .description(budget.getDescription())
                    .budgetEntitiesIds(budget.getBudgetEntitiesIds())
                    .budgetUsersIds(budget.getBudgetUsersIds())
                    .build();

        } else {
            throw new IllegalArgumentException("Budget not found for id: " + budgetId);
        }
    }
}
