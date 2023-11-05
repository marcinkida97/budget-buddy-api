package com.budgetbuddy.budget_buddy.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Getter
@Entity
@Table(name = "user_login_data")
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class UserLoginData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;

    @Column(name = "login")
    @NonNull
    private String login;

    @Column(name = "password")
    @NonNull
    private String password;

    @Column(name = "salt")
    @NonNull
    private String salt;
}
