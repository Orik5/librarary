package ua.lviv.dvoretskyi.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.hateoas.ResourceSupport;
import ua.lviv.dvoretskyi.entity.Author;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class AuthorDto extends ResourceSupport {


  private String name;
  private String surname;
  private String country;


  public static AuthorDto convertToDto(Author author) {
    return new AuthorDto(author.getName(), author.getSurname(), author.getCountry());

  }


}
