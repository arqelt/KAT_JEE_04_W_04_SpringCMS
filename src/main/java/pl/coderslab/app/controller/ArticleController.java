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
import pl.coderslab.app.repository.ArticleRepository;
import pl.coderslab.app.repository.AuthorRepository;
import pl.coderslab.app.repository.CategoryRepository;
import pl.coderslab.app.validation.ValidationArticle;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/article")
public class ArticleController {
    private final ArticleDao articleDao;
    private final CategoryDao categoryDao;
    private final AuthorDao authorDao;
    private final ArticleRepository articleRepository;
    private final CategoryRepository categoryRepository;
    private final AuthorRepository authorRepository;

    public ArticleController(ArticleDao articleDao, CategoryDao categoryDao, AuthorDao authorDao, ArticleRepository articleRepository, CategoryRepository categoryRepository, AuthorRepository authorRepository) {
        this.articleDao = articleDao;
        this.authorDao = authorDao;
        this.categoryDao = categoryDao;
        this.articleRepository = articleRepository;
        this.categoryRepository = categoryRepository;
        this.authorRepository = authorRepository;
    }
    @GetMapping("/all")
    public String getArticlesForm(Model model) {
        List<Article> articles = articleDao.findAll();
        model.addAttribute("articles", articles);
        return "articleForm";
    }
    @GetMapping("/byCategory")
    public String getByCategory(Model model, @PathVariable Long id) throws Exception {
        Optional<Category> byId = categoryRepository.findById(id);
        Category category = byId.orElseThrow(Exception::new);
        List<Article> articles = articleRepository.findByCategories(category);
        model.addAttribute("articles", articles);
        return "";
    }
    @GetMapping("/add")
    public String getSave(Model model) {
        model.addAttribute("article", new Article());
        return "articleAdd";
    }
    @PostMapping("/add")
    public String postSave(@ModelAttribute("article") @Validated({ValidationArticle.class}) Article article, BindingResult result) {
        if (result.hasErrors()) {
            return ("/article/add");
        }
        article.setCreated(LocalDateTime.now());
        //articleDao.save(article);
        articleRepository.save(article);
        return "redirect:/article/all";
    }
    @GetMapping("/edit/{id}")
    public String getEdit(Model model, @PathVariable Long id) throws Exception {
        //Article article = articleDao.getById(id);
        Article article = articleRepository.findById(id).orElseThrow(Exception::new);
        model.addAttribute("article", article);
        return "articleEdit";
    }
    @PostMapping("/edit/{id}")
    public String postEdit(@ModelAttribute("article") @Validated({ValidationArticle.class}) Article article, BindingResult result, @PathVariable Long id) {
        if (result.hasErrors()) {
            return "/article/all";
        }
        article.setUpdated(LocalDateTime.now());
        articleDao.update(article);
        return "redirect:/article/all";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        Article article = articleDao.getById(id);
        articleDao.delete(article);
        return "redirect:/article/all";
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
