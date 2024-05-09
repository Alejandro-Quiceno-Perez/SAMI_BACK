package com.sami.sami_app.api.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {
    private long idCustomer;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String rhType;
    private List<CustomerInService> customer;
}
