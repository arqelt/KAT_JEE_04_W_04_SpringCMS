package pl.coderslab.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.dao.AuthorDao;
import pl.coderslab.app.entity.Author;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/author")
public class AuthorController {
    private AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }
    @GetMapping("/all")
    public String getFormAuthors(Model model) {
        List<Author> authors = authorDao.findAll();
        model.addAttribute("authors", authors);
        return "authorForm";
    }
    @GetMapping("/add")
    public String getSave(Model model) {
        model.addAttribute("author", new Author());
        return "authorAdd";
    }
    @PostMapping("/add")
    public String postSave(@Valid @ModelAttribute Author author, BindingResult result) {
        if (result.hasErrors()) {
            return ("authorAdd");
        } else {
        authorDao.save(author);
        return "redirect:/author/all";
        }
    }
    @GetMapping("/edit/{id}")
    public String getEdit(Model model, @PathVariable Long id) {
        Author author = authorDao.getById(id);
        model.addAttribute("author",author);
        return "authorEdit";
    }
    @PostMapping("/edit/{id}")
    public String postEdit(@Valid @ModelAttribute("author") Author author, BindingResult result, @PathVariable Long id) {
        if (result.hasErrors()) {
            return "/author/all";
        }
        authorDao.update(author);
        return "redirect:/author/all";
    }
    @GetMapping("/detele/{id}")
    public String delete(@PathVariable Long id) {
        Author author = authorDao.getById(id);
        authorDao.delete(author);
        return "redirect: /author/all";
    }
}
