package com.budgetbuddy.budget_buddy.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name = "budget_buddy")
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserLoginData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private static UUID id;

    @Column(name = "login")
    private static String login;

    @Column(name = "email")
    private static String email;

    @Column(name = "password")
    private static String password;

    @Column(name = "salt")
    private static String salt;

}
