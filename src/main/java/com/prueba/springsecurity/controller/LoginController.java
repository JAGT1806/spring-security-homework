package com.prueba.springsecurity.controller;

import com.prueba.springsecurity.entity.RoleEntity;
import com.prueba.springsecurity.entity.UserEntity;
import com.prueba.springsecurity.service.imp.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String home(Model model) {
        List<UserEntity> users = userService.getAllUsers();
        List<Map<String, Object>> userList = new ArrayList<>();

        for (UserEntity user : users) {
            Map<String, Object> userMap = new HashMap<>();
            userMap.put("user", user);
            userMap.put("roles", user.getRoles().stream().map(RoleEntity::getRoleName).collect(Collectors.joining(", ")));
            userList.add(userMap);
        }

        model.addAttribute("userList", userList);
        return "home";
    }

    @GetMapping("/new")
    public String createUserForm(Model model) {
        model.addAttribute("user", new UserEntity()); // nuevo objeto UserEntity
        return "new"; // vista del formulario de creación
    }

    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }

    @GetMapping("/403")
    public String accessDenied() {
        return "403";
    }

}
