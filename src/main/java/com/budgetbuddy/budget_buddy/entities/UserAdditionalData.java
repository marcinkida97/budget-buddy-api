package com.budgetbuddy.budget_buddy.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Getter
@Entity
@Table(name = "user_additional_data")
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
public class UserAdditionalData {

    @Id
    @NonNull
    private UUID userId;

    @Column(name = "first_name")
    @NonNull
    private String firstName;

    @Column(name = "last_name")
    @NonNull
    private String lastName;

    @Column(name = "budget_ids")
    @NonNull
    @ElementCollection
    private List<UUID> budgetIds;
}
