package com.budgetbuddy.budget_buddy.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginData {

    private static UUID id;

    private static String login;

    private static String email;

    private static String password;

    private static String salt;

}
