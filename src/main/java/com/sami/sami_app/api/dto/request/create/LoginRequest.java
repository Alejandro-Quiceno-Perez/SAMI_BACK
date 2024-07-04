package com.sami.sami_app.api.dto.request.create;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    @Email
    @NotBlank(message = "The email is required")
    @Size(min = 3, max = 100, message = "email must be between 3 and 150 characters")
    private String email;
    @NotBlank(message = "The password is required")
    @Size(min = 3, max = 100, message = "Password must be between 3 and 150 characters")
    private String password;
}
