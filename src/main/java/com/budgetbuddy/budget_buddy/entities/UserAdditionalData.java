package com.budgetbuddy.budget_buddy.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "user_additional_data")
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserAdditionalData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private static UUID id;

    @Column(name = "first_name")
    private static String firstName;

    @Column(name = "last_name")
    private static String lastName;

    @Column(name = "budget_ids")
    private static List<String> budgetIds;
}
