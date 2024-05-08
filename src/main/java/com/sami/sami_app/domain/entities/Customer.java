package com.sami.sami_app.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*-
*---------------------------------------------------------------------------------------------------------------------------
*The "CUSTOMER" entity is created in order to manage the user's role with other entities. 
The costumer class defines the attributes of a costumer, such as its unique identifier.-------------------------------------------------
*/
@Entity(name = "customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private Long idCustomer;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_id_user", referencedColumnName = "id_user")
    private User user;
}
