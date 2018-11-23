package ua.lviv.dvoretskyi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.hateoas.ResourceSupport;
import ua.lviv.dvoretskyi.entity.Book;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class BookDto extends ResourceSupport {

  private String name;
  private int pages;
  private String description;

  public static BookDto convertToDto(Book book) {
    return new BookDto(book.getName(), book.getPages(), book.getDescription());

  }
}
