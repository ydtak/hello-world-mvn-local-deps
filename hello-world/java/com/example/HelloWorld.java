package com.example;

import com.example.library.HelloWorldLibrary;
import com.google.common.collect.ImmutableList;

public class HelloWorld {
  public static void main(String[] args) {
    ImmutableList<String> hellos = new HelloWorldLibrary().hellos();
    hellos.forEach(hello -> System.out.println(hello));
  }
}
