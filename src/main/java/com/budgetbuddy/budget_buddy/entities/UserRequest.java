package com.budgetbuddy.budget_buddy.entities;

import lombok.Getter;

@Getter
public class UserRequest {
    private String login;

    private String password;

    private String firstName;

    private String lastName;
}
