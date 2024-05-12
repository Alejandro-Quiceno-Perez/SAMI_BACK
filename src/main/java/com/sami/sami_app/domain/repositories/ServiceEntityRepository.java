package com.sami.sami_app.domain.repositories;


import com.sami.sami_app.domain.entities.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ServiceEntityRepository extends JpaRepository<ServiceEntity,Long> {


}
