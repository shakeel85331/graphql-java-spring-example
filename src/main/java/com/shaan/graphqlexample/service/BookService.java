package com.shaan.graphqlexample.service;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.shaan.graphqlexample.model.Book;
import com.shaan.graphqlexample.model.BookInput;
import com.shaan.graphqlexample.repository.BookRepository;
import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class BookService implements GraphQLQueryResolver, GraphQLMutationResolver {

  private final BookRepository bookRepository;

  @PostConstruct
  public void init() {
    log.info("Adding initial data to db");
    bookRepository.save(Book.builder().authorId(1).publication("Some").title("SpaceX").build());
    bookRepository.save(Book.builder().authorId(7).publication("OReally").title("Java questions").build());
    bookRepository.save(Book.builder().authorId(12).publication("Janus").title("Web development").build());
    bookRepository.save(Book.builder().authorId(4).publication("Fantom").title("GHO").build());
  }

  public List<Book> getAllBooks() {
    return bookRepository.findAll();
  }

  public Book getBookById(int id) {
    return Optional.ofNullable(bookRepository.findById(id)).get().orElse(null);
  }

  public List<Book> updateBook(int id, String publication) {
    Book book = getBookById(id);
    book.setPublication(publication);
    bookRepository.save(book);
    return getAllBooks();
  }

  public List<Book> addBook(BookInput bookInput) {
    bookRepository.save(Book.builder().authorId(bookInput.getAuthorId()).publication(bookInput.getPublication())
        .title(bookInput.getTitle()).build());
    return getAllBooks();
  }


}
