package pl.coderslab.app.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.app.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class AuthorDao {
    @PersistenceContext
    EntityManager entityManager;

    public Author getById(Long id){
        return entityManager.find(Author.class, id);
    }
    public void save(Author author){
        entityManager.persist(author);
    }
    public void update(Author author){
        entityManager.merge(author);
    }
    public void delete(Author author){
        entityManager.remove(entityManager.contains(author) ?
                author: entityManager.merge(author));
    }
}
