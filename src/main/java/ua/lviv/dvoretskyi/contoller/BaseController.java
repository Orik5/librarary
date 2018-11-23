package ua.lviv.dvoretskyi.contoller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.dvoretskyi.entity.Author;
import ua.lviv.dvoretskyi.entity.Book;
import ua.lviv.dvoretskyi.service.AuthorService;
import ua.lviv.dvoretskyi.service.BookService;
import ua.lviv.dvoretskyi.service.impl.BookServiceImpl;

@RestController
public class BaseController {

    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookService bookService;

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String home() {
//        return "home";
//    }
    @RequestMapping(value = "/saveBook", method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> saveBook(@RequestBody Book book) {
        bookService.save(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/saveAuthor", method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> saveAuthor(@RequestBody Author author) {
        authorService.add(author.getName(),author.getSurname(),author.getCountry());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
