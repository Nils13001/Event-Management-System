package com.pdi.CustomerMgmt.Repository;

import com.pdi.CustomerMgmt.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUserId(int userId);
}
