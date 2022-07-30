package com.efremov.preproject311.controllers;

import com.efremov.preproject311.models.User;
import com.efremov.preproject311.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showAll(Model model){
        model.addAttribute("allUsers", userService.getAllUsers());
        return "users/all-users";
    }

    @GetMapping("/new")
    public String showAddNewForm(Model model){
        model.addAttribute("new_user", new User());
        return "users/user-info";
    }

    @PostMapping("/saveUser")
    public String saveNew(@ModelAttribute("new_user") @Valid User user, BindingResult result){
        if (result.hasErrors()) {
            return "users/user-info";
        }
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "users/update-user";
    }

    @PatchMapping("/{id}/update")
    public String update(@PathVariable("id") int id, @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            user.setId(id);
            return "users/update-user";
        }
        userService.updateUser(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
