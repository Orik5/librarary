package ua.lviv.dvoretskyi.service.impl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.dvoretskyi.entity.Book;
import ua.lviv.dvoretskyi.repository.BookRepository;
import ua.lviv.dvoretskyi.service.BookService;

@Service
public class BookServiceImpl implements BookService {


  @Autowired
  private BookRepository bookRepository;

  @Override
  public void save(Book book) {
    bookRepository.add(book);
  }

  @Override
  public void add(String name, int pages, String description) {
    Book book = new Book(name, pages, description);
  }

  @Override
  public void edit(long id, String name, int pages, String description) {
    Book book = findById(id);

    if (name != null && !name.equalsIgnoreCase("")) {
      book.setName(name);
    }
    if (pages != 0) {
      book.setPages(pages);
    }
    if (description != null && !description.equalsIgnoreCase("")) {
      book.setDescription(description);
    }
    bookRepository.edit(book);
  }

  @Override
  public void delete(Book book) {
    bookRepository.delete(book);
  }

  @Override
  public Book findById(long id) {
    return
        bookRepository.findById(id);
  }

  @Override
  public List<Book> findAllBooks() {
    return bookRepository.findAll();
  }
}



