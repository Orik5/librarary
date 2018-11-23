package ua.lviv.dvoretskyi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;
  private int pages;
  private String description;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "book_authorID")
  private Author author;

  public Book(String name, int pages, String description) {
    this.name = name;
    this.pages = pages;
    this.description = description;
  }
}
