package com.budgetbuddy.budget_buddy.repositories;

import com.budgetbuddy.budget_buddy.entities.Budget;
import com.budgetbuddy.budget_buddy.entities.UserAdditionalData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BudgetRepository extends JpaRepository<Budget, UUID> {

//    Budget findBy(UUID id);
}
