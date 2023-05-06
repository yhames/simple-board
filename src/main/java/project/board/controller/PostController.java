package project.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import project.board.request.PostCreate;
import project.board.response.PostResponse;
import project.board.service.PostService;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public String index(Model model) {
        List<PostResponse> posts = postService.findAll();
        model.addAttribute("posts", posts);
        return "index";
    }

    @GetMapping("/{postId}")
    public String post(@PathVariable("postId") Long postId, Model model) {
        PostResponse post = postService.findById(postId);
        model.addAttribute("post", post);
        return "post";
    }

    @GetMapping("/new")
    public String newForm() {
        return "newForm";
    }

    @PostMapping("/new")
    public String save(@ModelAttribute PostCreate postCreate) {
        postService.save(postCreate);
        return "redirect:/";
    }

    // TODO : Update 기능 추가
}
