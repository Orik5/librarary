package ua.lviv.dvoretskyi.service;


import java.util.List;
import ua.lviv.dvoretskyi.entity.Author;

public interface AuthorService {

  void add(String name, String surname, String country);

  void edit(long id, String name, String surname, String country);

  void delete(Author author);

   Author findById(long id);

  List<Author> findAllAuthors();
}
