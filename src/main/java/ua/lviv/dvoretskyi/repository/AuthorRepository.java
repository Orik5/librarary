package ua.lviv.dvoretskyi.repository;


import java.util.List;
import ua.lviv.dvoretskyi.entity.Author;

public interface AuthorRepository /*extends JpaRepository<Author, Long>*/ {

  void add(Author author);

  void edit(Author author);

  void delete(Author author);

  Author findById(long id);

  List<Author> findAll();
}
