package com.sami.sami_app.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sami.sami_app.api.dto.request.ClientRegisterRequest;
import com.sami.sami_app.api.dto.request.LoginRequest;
import com.sami.sami_app.api.dto.request.RegisterRequest;
import com.sami.sami_app.api.dto.response.AuthResp;
import com.sami.sami_app.domain.entities.Account;
import com.sami.sami_app.domain.entities.User;
import com.sami.sami_app.domain.repositories.AccountRepository;
import com.sami.sami_app.domain.repositories.UserRepository;
import com.sami.sami_app.infrastructure.abstract_services.IAuthService;
import com.sami.sami_app.infrastructure.helpers.JwtService;
import com.sami.sami_app.util.enums.Role;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthService implements IAuthService {

    @Autowired
    private final AccountRepository accountRepository;
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final JwtService jwtService;
    @Autowired
    private final PasswordEncoder passwordEncoder; 
    @Autowired
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResp login(LoginRequest request) {
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        } catch (Exception e) {
            throw new RuntimeException("Invalid credentials");
        }

        Account account = this.findByUserEmail(request.getEmail());
        if (account == null) {
            throw new RuntimeException("User email is not registered");
        }

        return AuthResp.builder()
            .message("Authenticated properly")
            .token(this.jwtService.getToken(account))
            .build();
    }

    @Override
    public AuthResp register(RegisterRequest request) {
        //validates if the email exists in the database
        Account exist = this.findByUserEmail(request.getEmail());
        if (exist != null) {
            throw new RuntimeException("This email is already registered");
        }

        Account account = Account.builder()
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .role(Role.CLIENT)  // Default role for registration
            .build();

        this.accountRepository.save(account);

        return AuthResp.builder()
            .message("Successful registration")
            .token(this.jwtService.getToken(account))
            .build();
    }

    public AuthResp registerClient(ClientRegisterRequest request) {
        //validates if the email exists in the database
        Account exist = this.findByUserEmail(request.getEmail());
        if (exist != null) {
            throw new RuntimeException("The email is already registered");
        }

        Account account = Account.builder()
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .role(Role.CLIENT)  // Role for client registration
            .build();
        Account accountSave = this.accountRepository.save(account);

        User user = User.builder()
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .phone(request.getPhone())
            .rhType(request.getRhType())
            .account(accountSave)
            .build();
        this.userRepository.save(user);

        return AuthResp.builder()
            .message("Client registration successful")
            .token(this.jwtService.getToken(accountSave))
            .build();
    }

    public AuthResp registerAdmin(RegisterRequest request) {
        //validates if the email exists in the database
        Account exist = this.findByUserEmail(request.getEmail());
        if (exist != null) {
            throw new RuntimeException("The email is already registered");
        }

        Account account = Account.builder()
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .role(Role.ADMIN)  // Role for admin registration
            .build();

        this.accountRepository.save(account);

        return AuthResp.builder()
            .message("Admin registration successful")
            .token(this.jwtService.getToken(account))
            .build();
    }

    public AuthResp registerDriver(RegisterRequest request) {
        //validates if the email exists in the database
        Account exist = this.findByUserEmail(request.getEmail());
        if (exist != null) {
            throw new RuntimeException("The email is already registered");
        }

        Account account = Account.builder()
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .role(Role.DRIVER)  // Role for driver registration
            .build();

        this.accountRepository.save(account);

        return AuthResp.builder()
            .message("Driver registration successful")
            .token(this.jwtService.getToken(account))
            .build();
    }

    public AuthResp registerEmt(RegisterRequest request) {
        //validates if the email exists in the database
        Account exist = this.findByUserEmail(request.getEmail());
        if (exist != null) {
            throw new RuntimeException("The email is already registered");
        }

        Account account = Account.builder()
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .role(Role.EMT)  // Role for EMT registration
            .build();

        this.accountRepository.save(account);

        return AuthResp.builder()
            .message("EMT registration successful")
            .token(this.jwtService.getToken(account))
            .build();
    }

    private Account findByUserEmail(String userEmail) {
        return this.accountRepository.findByEmail(userEmail).orElse(null);
    }
}