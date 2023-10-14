package com.budgetbuddy.budget_buddy.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAdditionalData {

    private static UUID id;

    private static String firstName;

    private static String lastName;

    private static List<String> budgetIds;
}
