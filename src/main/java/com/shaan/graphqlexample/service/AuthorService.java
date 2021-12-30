package com.shaan.graphqlexample.service;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.shaan.graphqlexample.model.Author;
import com.shaan.graphqlexample.model.Book;
import com.shaan.graphqlexample.repository.AuthorRepository;
import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class AuthorService implements GraphQLQueryResolver {

  private final AuthorRepository authorRepository;

  @PostConstruct
  public void init() {
    log.info("Adding initial data to authors db");
    authorRepository.save(Author.builder().name("Shaan").address("213 Stesbd blvd").build());
    authorRepository.save(Author.builder().name("Ravi").address("453 lincoln blvd").build());
    authorRepository.save(Author.builder().name("Kisan").address("234 Greenpark blvd").build());
    authorRepository.save(Author.builder().name("Manoj").address("5656 Redwood blvd").build());
  }

  public List<Author> getAllAuthors(){
    return authorRepository.findAll();
  }

  public Author getAuthorById(int id) {
    return Optional.ofNullable(authorRepository.findById(id)).get().orElse(null);
  }

}
