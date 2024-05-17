package com.sami.sami_app.domain.entities;

import com.sami.sami_app.util.enums.RhType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
The "user" class defines the attributes related to the user, the unique identifier, the type of user and the user's personal information 
such as name, surname, blood type.
*---------------------------------------------------------------------------------------------------------------------------
*/
@Entity(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;

    @Column(name = "first_name", length = 30, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 30, nullable = false)
    private String lastName;

    @Column(length = 15, nullable = false)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name = "rh_type", nullable = false)
    private RhType rhType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_account", referencedColumnName = "id_account")
    private Account account;
}
