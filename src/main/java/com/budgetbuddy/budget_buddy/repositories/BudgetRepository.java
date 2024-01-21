package com.budgetbuddy.budget_buddy.repositories;

import com.budgetbuddy.budget_buddy.models.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BudgetRepository extends JpaRepository<Budget, UUID> {

    Optional<Budget> findByBudgetId(UUID budgetId);
}
