package com.budgetbuddy.budget_buddy.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "budget_entities")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "entityId")
public class BudgetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID entityId;

    @Column(name = "amount")
    @NonNull
    private float amount;

    @Column(name = "type")
    @NonNull
    private String type;

    @Column(name = "category")
    @NonNull
    private String category;

    @Column(name = "date", columnDefinition = "DATE")
    @NonNull
    private Date date;

    @Column(name = "budgetId")
    private UUID budgetId;
}

