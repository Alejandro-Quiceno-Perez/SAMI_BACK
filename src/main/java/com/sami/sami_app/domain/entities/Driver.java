package com.sami.sami_app.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

/*-
*----------------------------------------------------------------------------------------------------------
*The entity "Driver" is created with the purpose of handling the role of the user with other entities. It is also left with *the aim of being able to expand in the future the required or necessary information for this role.
*----------------------------------------------------------------------------------------------------------
*/

@Entity(name = "driver")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_driver")
    private Long idDriver;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_id_user", referencedColumnName = "id_user")
    private User user;

}