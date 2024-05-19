package com.sami.sami_app.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sami.sami_app.domain.entities.User;

public interface UserRepository extends JpaRepository<User,Long>  {
    
}
