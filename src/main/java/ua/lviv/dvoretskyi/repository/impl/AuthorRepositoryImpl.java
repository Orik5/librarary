package ua.lviv.dvoretskyi.repository.impl;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.dvoretskyi.entity.Author;
import ua.lviv.dvoretskyi.repository.AuthorRepository;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {

  @PersistenceContext(unitName = "Library")
  private EntityManager entityManager;

  @Transactional
  @Override
  public void add(Author author) {
    entityManager.persist(author);
  }

  @Transactional
  @Override
  public void edit(Author author) {
    entityManager.merge(author);
  }

  @Transactional
  @Override
  public void delete(Author author) {
    entityManager.remove(author);
  }

  @Transactional
  @Override
  public Author findById(long id) {
    return entityManager.find(Author.class, id);
  }

  @Transactional
  @Override
  public List<Author> findAll() {
    return entityManager.createQuery("select c from Author c").getResultList();
  }
}
