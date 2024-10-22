package com.prueba.springsecurity.service.imp;

import com.prueba.springsecurity.entity.RoleEntity;
import com.prueba.springsecurity.entity.UserEntity;
import com.prueba.springsecurity.repository.RoleRepository;
import com.prueba.springsecurity.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserSetupService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {

        // Crear los roles
        if(!roleRepository.existsByRole("ADMIN")) {
            RoleEntity role = new RoleEntity();
            role.setRole("ADMIN");
            roleRepository.save(role);
        }
        if (!roleRepository.existsByRole("USER")) {
            RoleEntity role = new RoleEntity();
            role.setRole("USER");
            roleRepository.save(role);
        }
        if (!roleRepository.existsByRole("EDITOR")) {
            RoleEntity role = new RoleEntity();
            role.setRole("EDITOR");
            roleRepository.save(role);
        }
        if (!roleRepository.existsByRole("CREATOR")) {
            RoleEntity role = new RoleEntity();
            role.setRole("CREATOR");
            roleRepository.save(role);
        }

        if (!userRepository.existsByUsername("ADMIN")) {
            // Crea el usuario ADMIN
            UserEntity adminUser = new UserEntity();
            adminUser.setUsername("ADMIN");
            adminUser.setPassword(passwordEncoder.encode("admin")); // Reemplaza con la contraseña que desees
            RoleEntity adminRole = roleRepository.findByRole("ADMIN")
                    .orElseThrow(() -> new RuntimeException("ADMIN role not found"));

            adminUser.getRoles().add(adminRole);

            adminUser.setEnabled(true);

            userRepository.save(adminUser);
        }
    }
}
