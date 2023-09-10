package com.example.library;

import com.google.common.collect.ImmutableList;

/** Class holding different greetings. */
public class HelloWorldLibrary {

  /** Returns hello in different languages. */
  public ImmutableList<String> hellos() {
    return ImmutableList.of("Hello", "Hola", "Bounjour");
  }
}
