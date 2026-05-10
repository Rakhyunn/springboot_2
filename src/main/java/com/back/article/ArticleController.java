package com.back.article;

import com.back.member.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;
    private final MemberService memberService;

    @GetMapping("/article/list")
    public String list(Model model, @RequestParam(defaultValue = "") String keyword) {
        List<Article> articleList = (keyword.isBlank())?
                articleService.findAll() : articleService.search(keyword);
        model.addAttribute(articleList);
        return "article_list";
    }

    @GetMapping("/article/create")
    public String create(ArticleForm articleForm) {
        return "article_create";
    }

    @GetMapping("article/detail/{id}")
    public String detail(Model model, @PathVariable("id") int id){
        Article article = articleService.findById(id);
        model.addAttribute(article);
        return "article_detail";
    }

    @GetMapping("/article/modify/{id}")
    public String modify(Model model, ArticleForm articleForm, @PathVariable("id") int id){
        Article article = articleService.findById(id);
        articleForm.setTitle(article.getTitle());
        articleForm.setContent(article.getContent());
        model.addAttribute(article);
        return "article_modify";
    }

    @PostMapping("/article/create")
    public String createArticle(@Valid ArticleForm articleForm, BindingResult bindingResult, Principal principal) {
        if (bindingResult.hasErrors()) {
           return "article_create";
        }
        articleService.save(articleForm.getTitle(), articleForm.getContent(), memberService.findByUsername(principal.getName()));
        return "redirect:/article/list";
    }

    @PostMapping("/article/modify/{id}")
    public String modifyArticle(Model model, @Valid ArticleForm articleForm, BindingResult bindingResult, @PathVariable("id") int id, Principal principal) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("article", articleService.findById(id));
            return "article_modify";
        }
        Article article = articleService.findById(id);
        if (!article.getAuthor().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        articleService.modify(id, articleForm.getTitle(), articleForm.getContent());
        return "redirect:/article/detail/" + id;
    }

    @PostMapping("/article/delete/{id}")
    public String deleteArticle(@PathVariable("id") int id, Principal principal) {
        Article article = articleService.findById(id);
        if (!article.getAuthor().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        articleService.delete(id);
        return "redirect:/article/list";
    }
}
