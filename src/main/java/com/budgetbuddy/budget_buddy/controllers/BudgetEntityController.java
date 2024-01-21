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
@RequestMapping("/api")
@CrossOrigin
public class BudgetEntityController {

    @Autowired
    BudgetEntityRepository budgetEntityRepository;

    @GetMapping("/budget-entities/{budgetEntityId}")
    public ResponseEntity<List<BudgetEntity>> getBudgetEntities(@PathVariable("budgetEntityId") UUID budgetEntityId) {
        try {
            List<BudgetEntity> budgetEntities = new ArrayList<BudgetEntity>(budgetEntityRepository.getBudgetEntities(budgetEntityId));
            if (budgetEntities.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(budgetEntities, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/budget-entities")
    public ResponseEntity<BudgetEntity> createBudgetEntity(@RequestBody BudgetEntity budgetEntity) {
        try {
            BudgetEntity _budgetEntity = budgetEntityRepository
                    .save(new BudgetEntity(
                            budgetEntity.getAmount(),
                            budgetEntity.getCurrency(),
                            budgetEntity.getCategory(),
                            budgetEntity.getBudgetId()
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