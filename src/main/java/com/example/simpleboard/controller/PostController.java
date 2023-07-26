package com.example.simpleboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post")
public class PostController {

    @GetMapping("/write")
    public String postAddForm() {
        return "post/postAddForm";
    }

    @GetMapping("/edit")
    public String postEditForm() {
        return "post/postEditForm";
    }

    @GetMapping()
    public String postDetailForm() {
        return "post/postDetailForm";
    }

}
