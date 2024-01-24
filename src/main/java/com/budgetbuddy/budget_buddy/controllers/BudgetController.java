package com.budgetbuddy.budget_buddy.controllers;

import com.budgetbuddy.budget_buddy.repositories.BudgetEntityRepository;
import com.budgetbuddy.budget_buddy.repositories.BudgetRepository;
import com.budgetbuddy.budget_buddy.requests.BudgetEntityRequest;
import com.budgetbuddy.budget_buddy.responses.BudgetEntityResponse;
import com.budgetbuddy.budget_buddy.responses.BudgetResponse;
import com.budgetbuddy.budget_buddy.services.BudgetEntityService;
import com.budgetbuddy.budget_buddy.services.BudgetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class BudgetController {

    private final BudgetService budgetService;

    @GetMapping("/getBudget/{budgetId}")
    public ResponseEntity<BudgetResponse> getBudgetById(@PathVariable UUID budgetId) {
        return ResponseEntity.ok(budgetService.getBudgetById(budgetId));
    }
}
