package com.prueba.springsecurity.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.security.Principal;

@Controller
public class AuthenticationController {
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/authentication")
    public String processLogin()  {
        return "redirect:/";
    }

    @GetMapping("/")
    public String showHomePage(Model model, Principal principal) {
        String username = principal.getName();
        return "home";
    }

    @GetMapping("/403")
    public String showAccessDeniedPage() {
        return "403";
    }

    // Rutas protegidas por roles
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CREATOR')")
    @GetMapping("/new")
    public String showNewPage() {
        return "new";
    }

    // Solo usuarios con ROLE_ADMIN o ROLE_EDITOR pueden acceder a esta ruta
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_EDITOR')")
    @GetMapping("/edit")
    public String showEditPage() {
        return "edit"; // La vista "edit.html" debe existir en /templates
    }

    // Solo usuarios con ROLE_ADMIN pueden acceder a esta ruta
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/delete")
    public String showDeletePage() {
        return "delete"; // La vista "delete.html" debe existir en /templates
    }
}
