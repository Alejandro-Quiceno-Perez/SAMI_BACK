package com.sami.sami_app.api.dto.response;

import com.sami.sami_app.util.enums.RhType;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO for user responses")
public class UserResponse {
    @Schema(description = "ID of the user", example = "1")
    private long id;
    @Schema(description = "First name of the user", example = "Juan")
    private String firstName;
    @Schema(description = "Last name of the user", example = "Pito")
    private String lastName;
    @Schema(description = "Phone number of the user", example = "3009876543")
    private String phone;
    @Schema(description = "Blood type AP (A+), AN (A-), BP (B+), BN (B-), ABP (AB+), ABN(AB-), OP (O+), ON(A-)",example = "AP")
    private RhType rhType;
}
