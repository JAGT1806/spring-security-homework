//package com.prueba.springsecurity.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import java.security.Principal;
//
//@Controller
//public class AuthController {
//
//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }
//
//    @GetMapping("/")
//    public String home(Model model, Principal principal) {
//        model.addAttribute("username", principal.getName());
//        return "home";
//    }
//
//    @GetMapping("/403")
//    public String accessDenied() {
//        return "403";
//    }
//}