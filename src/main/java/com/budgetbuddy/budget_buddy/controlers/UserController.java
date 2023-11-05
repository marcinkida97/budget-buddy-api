package com.budgetbuddy.budget_buddy.controlers;

import com.budgetbuddy.budget_buddy.entities.Budget;
import com.budgetbuddy.budget_buddy.entities.UserRequest;
import com.budgetbuddy.budget_buddy.entities.UserAdditionalData;
import com.budgetbuddy.budget_buddy.entities.UserLoginData;
import com.budgetbuddy.budget_buddy.repositories.BudgetRepository;
import com.budgetbuddy.budget_buddy.repositories.UserAdditionalDataRepository;
import com.budgetbuddy.budget_buddy.repositories.UserLoginDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.budgetbuddy.budget_buddy.utils.Messages.REGISTRATION_ERROR;
import static com.budgetbuddy.budget_buddy.utils.Messages.SUCCESS;
import static com.budgetbuddy.budget_buddy.utils.PasswordUtils.generateSalt;
import static com.budgetbuddy.budget_buddy.utils.PasswordUtils.hashPassword;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {

    @Autowired
    UserLoginDataRepository userLoginDataRepository;
    @Autowired
    UserAdditionalDataRepository userAdditionalDataRepository;
    @Autowired
    BudgetRepository budgetRepository;

    @GetMapping("/login")
    public ResponseEntity<UserAdditionalData> login(@RequestParam() String login, String password) {

        UserLoginData userLoginData;

        try {
            userLoginData = userLoginDataRepository.findByLogin(login);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        String encryptedPassword = hashPassword(password, userLoginData.getSalt());

        if (encryptedPassword.equals(userLoginData.getPassword())) {

            try {
                UserAdditionalData userAdditionalData = userAdditionalDataRepository.findByUserId(userLoginData.getUserId());
                return new ResponseEntity<>(userAdditionalData, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRequest userRequest) {
        String salt = generateSalt();
        try {
            UserLoginData _userLoginData = userLoginDataRepository
                    .save(new UserLoginData(
                            userRequest.getLogin(),
                            hashPassword(userRequest.getPassword(), salt),
                            salt
                            ));

            Budget _budget = budgetRepository
                    .save(new Budget(
                            "Main budget",
                            "This is my main budget"
                    ));

            List<UUID> budgetIds = new ArrayList<UUID>();
            budgetIds.add(_budget.getBudgetId());

            UserAdditionalData _userAdditionalData = userAdditionalDataRepository
                    .save(new UserAdditionalData(
                            _userLoginData.getUserId(),
                            userRequest.getFirstName(),
                            userRequest.getLastName(),
                            budgetIds
                    ));
            return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(REGISTRATION_ERROR + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}