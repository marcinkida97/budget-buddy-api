package com.budgetbuddy.budget_buddy.controllers;

import com.budgetbuddy.budget_buddy.responses.BudgetResponse;
import com.budgetbuddy.budget_buddy.services.BudgetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
