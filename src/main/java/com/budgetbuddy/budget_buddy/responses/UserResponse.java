package com.budgetbuddy.budget_buddy.responses;

import com.budgetbuddy.budget_buddy.models.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private UUID userId;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Set<UUID> usersBudgetsIds;
    private Role role;
}
