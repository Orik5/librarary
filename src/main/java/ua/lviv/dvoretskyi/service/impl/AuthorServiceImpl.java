package ua.lviv.dvoretskyi.service.impl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.dvoretskyi.entity.Author;
import ua.lviv.dvoretskyi.repository.AuthorRepository;
import ua.lviv.dvoretskyi.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

  @Autowired
  private AuthorRepository authorRepository;

  @Override
  public void add(String name, String surname, String country) {
    Author author = new Author(name, surname, country);
    authorRepository.add(author);
  }

  @Override
  public void edit(long id, String name, String surname, String country) {
    Author author = findById(id);
    if (name != null && !name.equalsIgnoreCase("")) {
      author.setName(name);
    }
    if (surname != null && !surname.equalsIgnoreCase("")) {
      author.setSurname(surname);
    }
    if (country != null && !country.equalsIgnoreCase("")) {
      author.setCountry(country);

      authorRepository.add(author);
    }
  }

  @Override
  public void delete(Author author) {
    authorRepository.delete(author);
  }

  @Override
  public Author findById(long id) {
    return authorRepository.findById(id);
  }

  @Override
  public List<Author> findAllAuthors() {
    return authorRepository.findAll();
  }


}