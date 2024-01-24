package com.budgetbuddy.budget_buddy.controllers;

import com.budgetbuddy.budget_buddy.requests.BudgetEntityRequest;
import com.budgetbuddy.budget_buddy.responses.BudgetEntityResponse;
import com.budgetbuddy.budget_buddy.services.BudgetEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class BudgetEntityController {
    private final BudgetEntityService budgetEntityService;

    @PostMapping("/addBudgetEntity")
    public ResponseEntity<BudgetEntityResponse> addBudgetEntity(@RequestBody BudgetEntityRequest request) {
        return ResponseEntity.ok(budgetEntityService.addBudgetEntity(request));
    }
}
