package pl.coderslab.app.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.app.entity.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ArticleDao {
    @PersistenceContext
    EntityManager entityManager;

    public Article getById(Long id){
        return entityManager.find(Article.class, id);
    }
    public void save(Article article){
        entityManager.persist(article);
    }
    public void update(Article article){
        entityManager.merge(article);
    }
    public void delete(Article article){
        entityManager.remove(entityManager.contains(article) ?
                article: entityManager.merge(article));
    }
}
