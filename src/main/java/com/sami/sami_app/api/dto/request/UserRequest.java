package com.sami.sami_app.api.dto.request;

import com.sami.sami_app.util.enums.RhType;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * USER REQUEST DTO
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO for user requests")
public class UserRequest {
    @NotBlank(message = "The first name is required")
    @Size(max = 30, message = "the first name must have a maximum of 30 characters")
    @Schema(description = "First Name", example = "Pepe")
    private String firstName;
    @NotBlank(message = "The last name is required")
    @Size(max = 30, message = "the last name must have a maximum of 30 characters")
    @Schema(description = "Last Name", example = "Perez")
    private String lastName;
    @NotBlank(message = "The phone is required")
    @Size(max = 15, message = "the phone must have a maximum of 15 characters")
    @Schema(description = "Phone Number", example = "3001234567")
    private String phone;
    @NotNull(message = "The RH is required")
    @Schema(description = "Blood type AP (A+), AN (A-), BP (B+), BN (B-), ABP (AB+), ABN(AB-), OP (O+), ON(A-)",example = "AP")
    private RhType rhType;
}
