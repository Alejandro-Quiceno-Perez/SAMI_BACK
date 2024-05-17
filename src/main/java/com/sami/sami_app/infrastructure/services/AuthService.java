package com.sami.sami_app.infrastructure.services;
import com.sami.sami_app.domain.entities.Account;
import com.sami.sami_app.domain.repositories.AccountRepository;
import com.sami.sami_app.infrastructure.helpers.JwtService;
import com.sami.sami_app.util.enums.Role;
import lombok.AllArgsConstructor;
import main.java.com.sami.sami_app.api.dto.request.LoginRequest;
import main.java.com.sami.sami_app.api.dto.request.RegisterRequest;
import main.java.com.sami.sami_app.api.dto.response.AuthResp;
import main.java.com.sami.sami_app.infrastructure.abstract_services.IAuthService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService implements  IAuthService{
    @Autowired
    private final AccountRepository accountRepository;
    @Autowired
    private final JwtService jwtService;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthResp login(LoginRequest request) {
        return null;
    }

    @Override
    public AuthResp regiter(RegisterRequest request) {
        Account exist = this.findByUserEmail(request.getEmail());

        if (exist != null) {
            throw new Exception ("This email is already registered");
        }

        Account account = Account.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ADMIN)
                .build();

        this.accountRepository.save(account);

        return AuthResp.builder()
                .message("Successful registration")
                .token(this.jwtService.getToken(account))
                .build();
    }
}
