package com.budgetbuddy.budget_buddy.services;

import com.budgetbuddy.budget_buddy.models.BudgetEntity;
import com.budgetbuddy.budget_buddy.repositories.BudgetEntityRepository;
import com.budgetbuddy.budget_buddy.requests.BudgetEntityRequest;
import com.budgetbuddy.budget_buddy.requests.GetBudgetEntitiesRequest;
import com.budgetbuddy.budget_buddy.responses.BudgetEntitiesListResponse;
import com.budgetbuddy.budget_buddy.responses.BudgetEntityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BudgetEntityService {

    private final BudgetEntityRepository budgetEntityRepository;

    public BudgetEntitiesListResponse getBudgetEntities(GetBudgetEntitiesRequest request) {
        var budgetEntitiesList = new ArrayList<BudgetEntity>();

        request.getBudgetEntitiesIds().forEach(budgetEntityId ->
                budgetEntitiesList.add(budgetEntityRepository.findByEntityId(budgetEntityId).orElseThrow()));

        return BudgetEntitiesListResponse.builder()
                .budgetEntitiesList(budgetEntitiesList)
                .build();
    }

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

    public boolean deleteBudgetEntityById(UUID budgetEntityId) {
        if (budgetEntityRepository.existsById(budgetEntityId)) {
            budgetEntityRepository.deleteById(budgetEntityId);
            return true;
        } else {
            return false;
        }
    }
}
