package com.budgetbuddy.budget_buddy.repositories;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BudgetEntry {

    UUID budgetEntryId;
    float amount;
    String definition;
    String category;
    Date date;
    String status;

    public static List<BudgetEntry> getBudgetEntrySampleData() {
        List<BudgetEntry> sampleData = new ArrayList<>();

        sampleData.add(new BudgetEntry(UUID.fromString("fd6f385f-96f9-478d-8a8a-8e96e80a7eb7"), 100.0f, "Salary", "Income", new Date(), "Received"));
        sampleData.add(new BudgetEntry(UUID.fromString("0f2de0e6-8166-4b4a-8dd5-3eaf0a8fbf72"), 50.0f, "Rent", "Expense", new Date(), "Paid"));
        sampleData.add(new BudgetEntry(UUID.fromString("f7b8d10a-e135-4f3e-a2c2-d1638b384b1d"), 25.0f, "Groceries", "Expense", new Date(), "Paid"));
        sampleData.add(new BudgetEntry(UUID.fromString("4ce72a60-5d9f-4d02-81ea-7d69ac6e3e45"), 200.0f, "Freelance Work", "Income", new Date(), "Received"));
        sampleData.add(new BudgetEntry(UUID.fromString("ed1d166c-5582-4293-aa60-33a946d2d76a"), 75.0f, "Utilities", "Expense", new Date(), "Paid"));

        return sampleData;
    }
}
