package pl.coderslab.app.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.app.dao.AuthorDao;
import pl.coderslab.app.entity.Author;

public class AuthorConverter implements Converter<String, Author> {
    @Autowired
    private AuthorDao authorDao;

    @Override
    public Author convert(String source) {
        System.out.println("KONWERTER TUTAJ1: " + source);
        System.out.println("KONWERTER tutAJ3:" + authorDao);
        System.out.println("KONWERTER tutAJ3:" + Long.parseLong(source));
        Author group = authorDao.getById(Long.parseLong(source));
        System.out.println("KONWERTER TUTAJ2: " + group);

        return group;
    }
}
