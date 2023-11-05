package com.budgetbuddy.budget_buddy.repositories;

import com.budgetbuddy.budget_buddy.entities.UserAdditionalData;
import com.budgetbuddy.budget_buddy.entities.UserLoginData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserAdditionalDataRepository extends JpaRepository<UserAdditionalData, UUID> {

    UserAdditionalData findByUserId(UUID id);
}
