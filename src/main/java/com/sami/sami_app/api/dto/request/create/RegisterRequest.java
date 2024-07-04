package com.sami.sami_app.api.dto.request.create;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @Email
    @NotBlank(message = "The Email is required")
    @Size(min = 3, max = 100, message = "Email must be between 3 and 150 characters")
    private String email;
    @NotBlank(message = "The password is required")
    @Size(min = 3, max = 100, message = "Password must be between 3 and 150 characters")
    private String password;
}
