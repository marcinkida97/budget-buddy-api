package com.budgetbuddy.budget_buddy.repositories;

import com.budgetbuddy.budget_buddy.models.Budget;
import com.budgetbuddy.budget_buddy.models.BudgetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BudgetEntityRepository extends JpaRepository<BudgetEntity, UUID> {

    Optional<BudgetEntity> findByEntityId(UUID entityId);
}
