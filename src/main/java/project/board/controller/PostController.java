package project.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.board.request.PostCreate;
import project.board.request.PostEdit;
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

    @GetMapping("/{postId}/edit")
    public String editForm(@PathVariable("postId") Long postId, Model model) {
        PostResponse post = postService.findById(postId);
        model.addAttribute("post", post);
        return "editForm";
    }

    @PostMapping("/{postId}/edit")
    public String update(@PathVariable("postId") Long postId, @ModelAttribute PostEdit postEdit) {
        postService.update(postId, postEdit);
        return "redirect:/{postId}";
    }

    @DeleteMapping("/{postId}/delete")
    public String delete(@PathVariable("postId") Long postId) {
        postService.delete(postId);
        return "redirect:/";
    }
}
