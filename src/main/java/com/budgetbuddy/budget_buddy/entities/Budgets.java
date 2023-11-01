package com.budgetbuddy.budget_buddy.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name = "budgets")
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Budgets {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private static UUID id;

    @Column(name = "name")
    private static String name;

    @Column(name = "description")
    private static String description;

    @Column(name = "category")
    private static String category;

}
