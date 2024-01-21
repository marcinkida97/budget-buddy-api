package com.budgetbuddy.budget_buddy.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "budgets")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "budgetId")
public class Budget {

    @Id
    @GeneratedValue
    private UUID budgetId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "budgets")
    @JsonBackReference
    private Set<User> users;

    @ManyToMany
    @JoinTable(
            name = "budget_budget_entities",
            joinColumns = @JoinColumn(name = "budget_id"),
            inverseJoinColumns = @JoinColumn(name = "entity_id")
    )
    private Set<BudgetEntity> budgetEntities;

    @Override
    public int hashCode() {
        return Objects.hash(budgetId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Budget budget = (Budget) obj;
        return Objects.equals(budgetId, budget.budgetId);
    }
}
