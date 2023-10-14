package com.budgetbuddy.budget_buddy.controlers;

import com.budgetbuddy.budget_buddy.repositories.BudgetEntry;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/budget-entries")
@CrossOrigin
public class BudgetEntryController {

    @GetMapping
    public List<BudgetEntry> getBudgetEntries() {
        return BudgetEntry.getBudgetEntrySampleData();
    }
}