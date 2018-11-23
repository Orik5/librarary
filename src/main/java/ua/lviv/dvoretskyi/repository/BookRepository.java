package ua.lviv.dvoretskyi.repository;


import java.util.List;
import ua.lviv.dvoretskyi.entity.Book;


public interface BookRepository /*extends JpaRepository<Book, Long>*/ {

  void add(Book book);

  void edit(Book book);

  void delete(Book book);

  Book findById(long id);

  List<Book> findAll();
}
