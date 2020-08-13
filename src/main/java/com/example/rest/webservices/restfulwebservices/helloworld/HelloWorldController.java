package com.example.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {

  @GetMapping(value = "/test")
  public String helloWorld() {
    return "Hello World !!!";
  }

  @GetMapping(value = "/bean")
  public HelloWorldBean helloWorldBean() {
    return new HelloWorldBean("Hello World", "Jaidip", 20);
  }

  @GetMapping(value = "/path-variable/{name}")
  public HelloWorldBean helloWorldPathName(@PathVariable String name) {
    return new HelloWorldBean("Hello World", String.format("Hello %s to Spring", name), 20);
  }
}
