package pl.coderslab.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.dao.CategoryDao;
import pl.coderslab.app.entity.Category;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    private CategoryDao categoryDao;

    public CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }
    @GetMapping("/all")
    public String getFormCategories(Model model) {
        List<Category> categories = categoryDao.findAll();
        model.addAttribute("categories", categories);
        return "categoryForm";
    }

    @GetMapping("/add")
    public String getSave (Model model) {
        model.addAttribute("category", new Category());
        return "categoryAdd";
    }
    @PostMapping("/add")
    public String postSave (@Valid @ModelAttribute("category") Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "/category/add";
        }
        categoryDao.save(category);
        return "/category/all";
    }
    @GetMapping("/edit/{id}")
    public String getEdit (Model model, @PathVariable Long id) {
        Category category = categoryDao.getById(id);
        model.addAttribute("category", category);
        return ("categoryEdit");
    }
    @PostMapping("/edit/{id}")
    public String postEdit (@Valid @ModelAttribute("category") Category category, BindingResult result, @PathVariable Long id) {
        if(result.hasErrors()) {
            return "/category/all";
        }
        categoryDao.update(category);
        return ("redirect: /category/all");
    }
    @GetMapping("/delete/{id}")
    public String delete (@PathVariable Long id) {
        Category category = categoryDao.getById(id);
        categoryDao.delete(category);
        return ("redirect: /category/all");
    }


}
