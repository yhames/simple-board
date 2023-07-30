package com.example.simpleboard.controller;

import com.example.simpleboard.domain.User;
import com.example.simpleboard.request.UserRequest;
import com.example.simpleboard.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public String loginForm() {
        return "/user/loginForm";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserRequest userRequest, HttpSession session) {
        Optional<User> findUser = userService.findByName(userRequest.getName());

        if (findUser.isEmpty()) {
            return "redirect:/user/login";
        }

        User user = findUser.get();
        if (!userRequest.getPassword().equals(user.getPassword())) {
            return "redirect:/user/login";
        }

        session.setAttribute("userId", user.getId());
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("userId");
        return "redirect:/";
    }
}
