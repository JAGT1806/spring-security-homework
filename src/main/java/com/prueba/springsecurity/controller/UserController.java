package com.prueba.springsecurity.controller;

import com.prueba.springsecurity.entity.UserEntity;
import com.prueba.springsecurity.service.imp.RoleService;
import com.prueba.springsecurity.service.imp.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    // Mostrar todos los usuarios
    @GetMapping
    public String listUsers(Model model) {
        List<UserEntity> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "user/list"; // vista que muestra la lista de usuarios
    }

    // Mostrar el formulario para crear un nuevo usuario


    // Manejar el envío del formulario para crear un nuevo usuario
    @PostMapping("/new")
    public String createUser(@ModelAttribute UserEntity user, @RequestParam List<Integer> roleIds) {
        userService.saveUser(user, roleIds);
        return "redirect:/home"; // redirigir a la lista de usuarios después de crear
    }

    // Mostrar el formulario para editar un usuario existente
    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable Integer id, Model model) {
        UserEntity user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user/edit"; // vista del formulario de edición
    }

    // Manejar el envío del formulario para editar un usuario existente
    @PostMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, @ModelAttribute UserEntity user, @RequestParam List<Integer> roleIds) {
        user.setUserId(id); // asegurarse de que el ID del usuario sea correcto
        userService.saveUser(user, roleIds);
        return "redirect:/users"; // redirigir a la lista de usuarios después de editar
    }

    // Manejar la eliminación de un usuario
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return "redirect:/users"; // redirigir a la lista de usuarios después de eliminar
    }
}

