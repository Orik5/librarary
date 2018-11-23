package ua.lviv.dvoretskyi.repository.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.dvoretskyi.entity.Book;
import ua.lviv.dvoretskyi.repository.BookRepository;

@Repository
public class BookRepositoryImpl implements BookRepository {


  @PersistenceContext(unitName = "Library")
  private EntityManager entityManager;

  @Transactional
  @Override
  public void add(Book book) {
    entityManager.persist(book);
  }

  @Transactional
  @Override
  public void edit(Book book) {
    entityManager.merge(book);
  }

  @Transactional
  @Override
  public void delete(Book book) {
    entityManager.remove(book);
  }

  @Transactional
  @Override
  public Book findById(long id) {
    return entityManager.find(Book.class, id);
  }

  @Override
  public List<Book> findAll() {
    return entityManager.createQuery("select c from Book c").getResultList();
  }
}

