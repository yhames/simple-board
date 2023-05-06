package project.board.controller;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import project.board.domain.Post;
import project.board.request.PostCreate;

@Slf4j
@Controller
public class PostController {

    @GetMapping
    public String index(Model model) {
        log.info("index page");
//        model.addAttribute();
        return "index";
    }

    @GetMapping("/new")
    public String newForm() {
        log.info("new Form call");
        return "new";
    }

    @PostMapping("/new")
    public String save(@ModelAttribute PostCreate postCreate) {
        log.info("postCreate={}", postCreate);
        log.info("title={}, content={}", postCreate.getTitle(), postCreate.getContent());
        return "redirect:/";
    }
}
