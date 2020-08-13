package com.example.rest.webservices.restfulwebservices.helloworld;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloWorldBean {
  private String message;
  private String name;
  private int age;

  public HelloWorldBean(String message, String name, int age) {
    this.message = message;
    this.name = name;
    this.age = age;
  }
}
