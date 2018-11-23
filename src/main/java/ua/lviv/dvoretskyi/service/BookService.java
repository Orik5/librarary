package ua.lviv.dvoretskyi.service;


import java.util.List;
import ua.lviv.dvoretskyi.entity.Book;

public interface BookService {

  void add(String name, int pages, String description);

  void save(Book book);

  void edit(long id, String name, int pages, String description);

  void delete(Book book);

  Book findById(long id);

  //List<Book> findAllBooksDto();

  List<Book> findAllBooks();

}
