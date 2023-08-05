package com.example.simpleboard.controller;

import com.example.simpleboard.domain.Category;
import com.example.simpleboard.domain.User;
import com.example.simpleboard.request.PostRequest;
import com.example.simpleboard.response.UserResponse;
import com.example.simpleboard.service.PostService;
import com.example.simpleboard.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final UserService userService;

    @GetMapping("/write")
    public String postCreateForm(HttpSession session, Model model) {
        // session에 userId가 없으면
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "user/loginForm";
        }

        // session의 userId가 등록된 유저가 아니면
        Optional<User> findUser = userService.findById(userId);
        if (findUser.isEmpty()) {
            return "user/loginForm";
        }

        PostRequest postRequest = PostRequest.builder()
                .userId(userId)
                .build();
        model.addAttribute("postRequest", postRequest);
        return "post/postCreateForm";
    }

    @PostMapping("/write")
    public String postCreate(@ModelAttribute PostRequest postRequest, BindingResult bindingResult) {
        if (postRequest.getBoardId() <= 0) {
            bindingResult.addError(new FieldError("postRequest", "boardId", postRequest.getBoardId(),
                    false, new String[]{"post.empty.boardId"}, null, null));
        }

        if (postRequest.getTitle() == null || postRequest.getTitle().isBlank()) {
            bindingResult.addError(new FieldError("postRequest", "title", postRequest.getTitle(),
                    false, new String[]{"post.empty.title"}, null, null));
        }

        if (postRequest.getContent() == null || postRequest.getContent().isBlank()) {
            bindingResult.addError(new FieldError("postRequest", "content", postRequest.getContent(),
                    false, new String[]{"post.empty.content"}, null, null));
        }

        // 검증 실패
        if (bindingResult.hasErrors()) {
            log.info("validation failed={}", bindingResult);
            return "post/postCreateForm";
        }

        // 검증 성공
        postService.insert(postRequest);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String postEditForm() {
        return "post/postEditForm";
    }

    @GetMapping("/{id}")
    public String postDetailForm(@PathVariable long id, Model model) {
        model.addAttribute("post", postService.findById(id));
        return "post/postDetailForm";
    }

}
