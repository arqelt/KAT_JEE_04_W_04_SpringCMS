package pl.coderslab.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.dao.ArticleDao;
import pl.coderslab.app.dao.AuthorDao;
import pl.coderslab.app.dao.CategoryDao;
import pl.coderslab.app.entity.Article;
import pl.coderslab.app.entity.Author;
import pl.coderslab.app.entity.Category;
import pl.coderslab.app.validation.ValidationDraft;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/draft")
public class DraftController {
    private final ArticleDao articleDao;
    private final CategoryDao categoryDao;
    private final AuthorDao authorDao;

    public DraftController(ArticleDao articleDao, CategoryDao categoryDao, AuthorDao authorDao) {
        this.articleDao = articleDao;
        this.categoryDao = categoryDao;
        this.authorDao = authorDao;
    }
    @GetMapping("/all")
    public String getDraftsForm(Model model) {
        model.addAttribute("articles", articleDao.findDrafts());
        return "dratfForm";
    }
    @GetMapping("/add")
    public String getSave(Model model) {
        model.addAttribute("article",new Article());
        return "draftAdd";
    }
    @PostMapping("/add")
    public String postSave(@ModelAttribute("article") @Validated({ValidationDraft.class}) Article article, BindingResult result) {
        if (result.hasErrors()) {
            return "/draft/add";
        }
        article.setCreated(LocalDateTime.now());
        articleDao.save(article);
        return "redirect:/draft/all";
    }
    @GetMapping("/edit/{id}")
    public String getEdit(Model model, @PathVariable Long id) {
        Article article = articleDao.getById(id);
        model.addAttribute("article", article);
        return "draftEdit";
    }
    @PostMapping("/edit/{id}")
    public String postEdit(@ModelAttribute("article") @Validated({ValidationDraft.class}) Article article, BindingResult result) {
        if (result.hasErrors()) {
            return "/draft/all";
        }
        article.setUpdated(LocalDateTime.now());
        articleDao.update(article);
        return "redirect:/draft/all";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        articleDao.delete(articleDao.getById(id));
        return "draftForm";
    }
    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryDao.findAll();
    }
    @ModelAttribute("authors")
    public List<Author> authors() {
        return authorDao.findAll();
    }
}
