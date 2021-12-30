package com.shaan.graphqlexample.model;

import graphql.schema.GraphQLInputType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookInput implements GraphQLInputType {

  /**
   * @return the name of the type which MUST fit within the regular expression {@code [_A-Za-z][_0-9A-Za-z]*}
   */
  @Override
  public String getName() {
    return "addNewBook";
  }

  int id;
  String title;
  String publication;
  int authorId;
}
