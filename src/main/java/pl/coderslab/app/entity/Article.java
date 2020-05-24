package pl.coderslab.app.entity;

import pl.coderslab.app.validation.ValidationArticle;
import pl.coderslab.app.validation.ValidationDraft;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200)
    @NotNull(groups = {ValidationDraft.class, ValidationArticle.class})
    @Max(value = 200, groups = {ValidationArticle.class})
    private String title;
    @NotNull(groups = {ValidationDraft.class, ValidationArticle.class})
    @Min(value = 500, groups = {ValidationArticle.class})
    private String content;
    private LocalDateTime created;
    private LocalDateTime updated;
    private Boolean draft;
    @OneToOne
    @JoinColumn(name = "authors")
    private Author author;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "categories")
    @NotEmpty
    private List<Category> categories = new ArrayList<>();


    @PrePersist
    public void prePersist(){
        created = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        updated = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
