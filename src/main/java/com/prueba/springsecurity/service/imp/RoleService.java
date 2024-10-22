package com.prueba.springsecurity.service.imp;

import com.prueba.springsecurity.entity.RoleEntity;
import com.prueba.springsecurity.repository.RoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<RoleEntity> getAllRoles() {
        return roleRepository.findAll();
    }

    public void saveRole(RoleEntity role) {
        roleRepository.save(role);
    }
}

