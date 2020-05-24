package pl.coderslab.app.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.app.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CategoryDao {
    @PersistenceContext
    EntityManager entityManager;

    public Category getById(Long id){
        return entityManager.find(Category.class, id);
    }

    public void save(Category category){
        entityManager.persist(category);
    }

    public  void update(Category category){
        entityManager.merge(category);
    }
    public void delete(Category category){
        entityManager.remove(entityManager.contains(category) ?
                category: entityManager.merge(category));
    }
    public List<Category> findAll(){
        Query query = entityManager.createQuery("SELECT c FROM Category c");
        List categories = query.getResultList();
        return categories;
    }
}
