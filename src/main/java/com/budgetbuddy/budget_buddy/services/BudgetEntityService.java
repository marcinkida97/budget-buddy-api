package com.budgetbuddy.budget_buddy.services;

import com.budgetbuddy.budget_buddy.models.BudgetEntity;
import com.budgetbuddy.budget_buddy.repositories.BudgetEntityRepository;
import com.budgetbuddy.budget_buddy.requests.BudgetEntityRequest;
import com.budgetbuddy.budget_buddy.responses.BudgetEntityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BudgetEntityService {

    private final BudgetEntityRepository budgetEntityRepository;

    public BudgetEntityResponse addBudgetEntity(BudgetEntityRequest request) {
            var budgetEntity = BudgetEntity.builder()
                    .amount(request.getAmount())
                    .type(request.getType())
                    .category(request.getCategory())
                    .date(request.getDate())
                    .budgetId(request.getBudgetId())
                    .build();

            budgetEntityRepository.save(budgetEntity);

            return BudgetEntityResponse.builder()
                    .entityId(budgetEntity.getEntityId())
                    .amount(budgetEntity.getAmount())
                    .type(budgetEntity.getType())
                    .category(budgetEntity.getCategory())
                    .date(budgetEntity.getDate())
                    .budgetId(budgetEntity.getBudgetId())
                    .build();
    }
}
