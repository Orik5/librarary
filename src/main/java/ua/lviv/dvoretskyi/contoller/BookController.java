package ua.lviv.dvoretskyi.contoller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.dvoretskyi.entity.Book;
import ua.lviv.dvoretskyi.service.impl.BookServiceImpl;


@RestController
@RequestMapping("/api")
@Api(value = "library")

@EnableHypermediaSupport(type = HypermediaType.HAL)
public class BookController {

  /**
   * The constant logger.
   */
  public static final Logger logger = LoggerFactory.getLogger(BookController.class);
  @Autowired
  private BookServiceImpl bookService;


  @ApiOperation(value = "View a list of humans", response = Iterable.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Successfully retrieved list"),
      @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
      @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
      @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
  }
  )

  /*@RequestMapping(value = "/books", method = RequestMethod.GET, produces = {
      "application/hal+json"})
  public List<Book> getAllHumans() {
    return bookService.findAllBook();

  }*/

  /*  List<Human> allHumans = humanService.findAllHumans();
    Link link = linkTo(HateoasController.class).withSelfRel();
    Resources<HumanDto> result = new Resources<>allHumans, link);
    return result;*/



 /* @RequestMapping(value = "/humans{id}", method = RequestMethod.GET)
  public Human getHumanById(@PathVariable long id) {
    return humanService.findById(id);
  }
*/
/*
  @RequestMapping(method = RequestMethod.GET, produces = {"application/hal+json"})
  public Resources<Human> getAllCustomers() {
    List<Human> allHumans = humanService.findAllHumans();

    for (Human human : allHumans) {
      Long humanId = human.getId();
      Link selfLink = linkTo(HumanController.class).slash(humanId).withSelfRel();
      human.add(selfLink);
      if (humanService.findById(humanId) != null) {
        Link ordersLink = linkTo(methodOn(HumanController.class)
            .getOrdersForCustomer(humanId)).withRel("allOrders");
        human.add(ordersLink);
      }
    }

    Link link = linkTo(HumanController.class).withSelfRel();
    Resources<Human> result = new Resources<Human>(allHumans, link);
    return result;
  }

  private Class<?> getOrdersForCustomer(Long humanId) {
    return null;
  }

*/
  //@ApiOperation(value = "Get all books")
//@RequestMapping(value = "/books")

  @RequestMapping(value = "/books", method = GET)
  public void BookController(@PathVariable Book book) {
    bookService.findAllBooks();
  }

  //@ApiOperation(value = "Search book by Id", response = Book.class)
  @RequestMapping(value = "/books{id}", method = GET)
  public void getBook(@PathVariable("id") long id) {
    bookService.findById(id);
  }

  @ApiOperation(value = "Add book")
  @RequestMapping(value = "/books", method = POST)
  public void addBook(Book book) {
    bookService.save(book);

  }


  @ApiOperation(value = "Update book")
  @RequestMapping(value = "/books{id}", method = RequestMethod.PUT)
  public ResponseEntity<Void> updateBook(@RequestBody Book book, @PathVariable long id) {

    Optional<Book> bookOptional = Optional.ofNullable(bookService.findById(id));

    if (!bookOptional.isPresent()) {
      return ResponseEntity.notFound().build();
    }

    book.setId(id);

    bookService.save(book);

    return ResponseEntity.noContent().build();
  }

  @ApiOperation(value = "Delete book")
  @RequestMapping(value = "/books{id}", method = RequestMethod.DELETE)
  public void deleteBook(@PathVariable Book book) {
    bookService.delete(book);
  }
}
