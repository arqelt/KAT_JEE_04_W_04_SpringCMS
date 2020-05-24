package pl.coderslab.app.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.app.entity.Article;

import javax.management.QueryEval;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

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
    public List<Article> findAll(){
        Query query = entityManager.createQuery("SELECT a FROM Article a");
        List articles = query.getResultList();
        return articles;
    }
    public List<Article> findLastFive() {
        Query query = entityManager.createQuery("SELECT a FROM Article a ORDER BY a.created DESC");
        query.setMaxResults(5);
        List articles = query.getResultList();
        return articles;
    }
    public List<Article> findDrafts() {
        Query query = entityManager.createQuery("SELECT a FROM Article a where a.draft = true ");
        List drafts = query.getResultList();
        return drafts;
    }
}
