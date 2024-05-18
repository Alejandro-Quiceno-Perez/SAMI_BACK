package com.sami.sami_app.domain.entities;

import java.util.List;

import com.sami.sami_app.util.enums.ComplexityGrade;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*-
*-----------------------------------------------------------------------------------------------------------------------
 The Hospital class defines the attributes of a hospital, such as its unique identifier, 
 name, degree of complexity, address, specialty and location. These attributes are assigned 
 to the corresponding columns in the database using the Column decorator, with specific 
 sizes and specifications depending on the requirements.
*------------------------------------------------------------------------------------------------------------------------
*/

@Entity(name = "hospital")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hospital")
    private Long idHospital;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "latitude_location", nullable = false)
    private Double latitude;

    @Column(name = "longitude_location", nullable = false)
    private Double longitude;

    @Column(nullable = false, length = 200)
    private String address;

    @Column(name = "complexity_grade", nullable = false)
    @Enumerated(EnumType.STRING)
    private ComplexityGrade complexityGrade;

    @Column(nullable = false)
    private String specialty;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "hospital", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
    private List<ServiceEntity> services;
}
