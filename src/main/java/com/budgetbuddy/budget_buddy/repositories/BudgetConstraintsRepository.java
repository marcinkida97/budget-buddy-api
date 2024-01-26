package com.budgetbuddy.budget_buddy.repositories;

import com.budgetbuddy.budget_buddy.models.Budget;
import com.budgetbuddy.budget_buddy.models.BudgetConstraints;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BudgetConstraintsRepository extends JpaRepository<BudgetConstraints, UUID> {

    Optional<BudgetConstraints> findByBudgetConstraintId(UUID budgetConstraintId);
}
