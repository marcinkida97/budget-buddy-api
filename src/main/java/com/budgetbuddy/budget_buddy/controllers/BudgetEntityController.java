package com.budgetbuddy.budget_buddy.controllers;

import com.budgetbuddy.budget_buddy.models.BudgetEntity;
import com.budgetbuddy.budget_buddy.repositories.BudgetEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/data")
@CrossOrigin
public class BudgetEntityController {

    @Autowired
    BudgetEntityRepository budgetEntityRepository;

    @PostMapping("/budget-entities")
    public ResponseEntity<BudgetEntity> createBudgetEntity(@RequestBody BudgetEntity budgetEntity) {
        try {
            BudgetEntity _budgetEntity = budgetEntityRepository
                    .save(new BudgetEntity(
                            budgetEntity.getAmount(),
                            budgetEntity.getCurrency(),
                            budgetEntity.getCategory(),
                            budgetEntity.getDate()
                    ));
            return new ResponseEntity<>(_budgetEntity, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/budget-entities/{budgetEntityId}")
    public ResponseEntity<HttpStatus> deleteBudgetEntity(@PathVariable("budgetEntityId") UUID budgetEntityId) {
        try {
            budgetEntityRepository.deleteById(budgetEntityId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}