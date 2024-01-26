package com.budgetbuddy.budget_buddy.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "budgets_constraints")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "budgetConstraintId")
public class BudgetConstraints {

    @Id
    @GeneratedValue
    private UUID budgetConstraintId;

    @Column(name = "budget_id")
    private UUID budgetId;

    @Column(name = "isPrimary")
    private boolean isPrimary;

    @Override
    public int hashCode() {
        return Objects.hash(budgetConstraintId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BudgetConstraints budgetConstraints = (BudgetConstraints) obj;
        return Objects.equals(budgetConstraintId, budgetConstraints.budgetConstraintId);
    }
}