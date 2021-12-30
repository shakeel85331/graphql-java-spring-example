package com.shaan.graphqlexample.service;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.shaan.graphqlexample.model.Author;
import com.shaan.graphqlexample.model.Book;
import com.shaan.graphqlexample.repository.AuthorRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthorResolverService implements GraphQLResolver<Book> {

  private final AuthorRepository authorRepository;

  public Author getAuthor(Book book){
    return Optional.ofNullable(authorRepository.findById(book.getAuthorId())).get().orElse(null);
  }

}
