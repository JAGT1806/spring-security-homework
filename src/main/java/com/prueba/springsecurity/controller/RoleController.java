//package com.prueba.springsecurity.controller;
//
//import com.prueba.springsecurity.entity.RoleEntity;
//import com.prueba.springsecurity.service.imp.RoleService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/roles")
//@PreAuthorize("hasAuthority('ADMIN')")
//public class RoleController {
//    @Autowired
//    private RoleService roleService;
//
//    @GetMapping("")
//    public String listRoles(Model model) {
//        List<RoleEntity> roles = roleService.getAllRoles();
//        model.addAttribute("roles", roles);
//        return "roles/list";  // roles/list.html
//    }
//
//    @GetMapping("/new")
//    public String showCreateForm(Model model) {
//        model.addAttribute("role", new RoleEntity());
//        return "roles/form";  // roles/form.html
//    }
//
//    @PostMapping("/save")
//    public String saveRole(@ModelAttribute RoleEntity role) {
//        roleService.saveRole(role);
//        return "redirect:/roles";
//    }
//}
