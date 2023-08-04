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
    public String postCreate(@ModelAttribute PostRequest postRequest, Model model) {
        // TODO : BindingResult 처리

        Map<String, String> errors = new HashMap<>();   // Map<필드, 메시지>

        if (postRequest.getBoardId() <= 0) {
            errors.put("boardId", "게시판을 선택해주세요.");
        }

        if (postRequest.getTitle() == null || postRequest.getTitle().isBlank()) {
            errors.put("title", "제목을 입력해주세요.");
        }

        if (postRequest.getContent() == null || postRequest.getContent().isBlank()) {
            errors.put("content", "내용을 입력해주세요.");
        }

        // 검증 실패
        if (!errors.isEmpty()) {
            log.info("validation failed={}", errors);
            model.addAttribute("errors", errors);
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
