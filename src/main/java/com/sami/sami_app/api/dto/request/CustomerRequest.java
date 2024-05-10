package com.sami.sami_app.api.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {
    @NotBlank(message ="The email is required")
    @Size( max = 50, message = "the email must have a maximum of 50 characters")
    private String email;
    @NotBlank(message ="The password is required")
    @Size( max = 20, message = "the password must have a maximum of 20 characters")
    private String password;
    @NotBlank(message = "The first name is required")
    @Size( max = 30, message = "the first name must have a maximum of 30 characters")
    private String firstName;
    @NotBlank(message = "The last name is required")
    @Size( max = 30, message = "the last name must have a maximum of 30 characters")
    private String lastName;
    @NotBlank(message = "The phone is required")
    @Size( max = 15, message = "the phone must have a maximum of 15 characters")
    private String UserPhone;
    private String UserRhType;
}
