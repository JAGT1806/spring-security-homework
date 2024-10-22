package com.prueba.springsecurity.repository;

import com.prueba.springsecurity.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
    Optional<RoleEntity> findByRole(String role);

    boolean existsByRole(String role);
}
