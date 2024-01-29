package com.budgetbuddy.budget_buddy.services;

import com.budgetbuddy.budget_buddy.models.User;
import com.budgetbuddy.budget_buddy.repositories.UserRepository;
import com.budgetbuddy.budget_buddy.responses.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public UserResponse getUserById(UUID userId) {
        Optional<User> userOptional = userRepository.findByUserId(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            return UserResponse.builder()
                    .userId(user.getUserId())
                    .firstname(user.getFirstname())
                    .lastname(user.getLastname())
                    .email(user.getEmail())
                    .password(user.getPassword())
                    .usersBudgetsIds(user.getUsersBudgetsIds())
                    .role(user.getRole())
                    .build();

        } else {
            throw new IllegalArgumentException("Budget not found for id: " + userId);
        }
    }
}
