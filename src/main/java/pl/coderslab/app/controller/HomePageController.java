package pl.coderslab.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.app.dao.ArticleDao;
import pl.coderslab.app.dao.AuthorDao;
import pl.coderslab.app.dao.CategoryDao;
import pl.coderslab.app.entity.Category;
import pl.coderslab.app.repository.CategoryRepository;

import java.util.List;

@Controller
public class HomePageController {

    private final ArticleDao articleDao;
    private final CategoryRepository categoryRepository;

    public HomePageController(ArticleDao articleDao, CategoryRepository categoryRepository) {
        this.articleDao = articleDao;
        this.categoryRepository = categoryRepository;
    }
    @GetMapping(value = "/")
    public String home(Model model) {
        //List<Article> articles = articleDao.findLastFive();
        //model.addAttribute("articles", articles);
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);

        return "home";
    }


}
