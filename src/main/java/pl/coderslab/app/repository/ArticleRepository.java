package pl.coderslab.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.app.entity.Article;
import pl.coderslab.app.entity.Category;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    List<Article> findByCategories(Category category);
}
