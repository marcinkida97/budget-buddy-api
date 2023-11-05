package com.budgetbuddy.budget_buddy.repositories;

import com.budgetbuddy.budget_buddy.entities.BudgetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface BudgetEntityRepository extends JpaRepository<BudgetEntity, UUID> {

    @Query("SELECT b FROM BudgetEntity b WHERE b.budgetId = :budgetId")
    List<BudgetEntity> getBudgetEntities(@Param("budgetId") UUID budgetId);
}
