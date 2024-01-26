package com.budgetbuddy.budget_buddy.services;

import com.budgetbuddy.budget_buddy.security.JwtService;
import com.budgetbuddy.budget_buddy.models.Role;
import com.budgetbuddy.budget_buddy.models.User;
import com.budgetbuddy.budget_buddy.requests.AuthenticationRequest;
import com.budgetbuddy.budget_buddy.requests.RegisterRequest;
import com.budgetbuddy.budget_buddy.responses.AuthenticationResponse;
import com.budgetbuddy.budget_buddy.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final BudgetService budgetService;

    public AuthenticationResponse register(RegisterRequest request) {
        var budget = budgetService.createBudget();

        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .usersBudgetsIds(new HashSet<>(Collections.singletonList(budget.getBudgetId())))
                .build();

        var savedUser = userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .userId(user.getUserId())
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .userId(user.getUserId())
                .build();
    }
}
