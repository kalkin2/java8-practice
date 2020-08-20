package com.java8.demo.optional.optionalCrashCourse;

import java.util.Optional;

public class Exam1 {

  public static void main(String[] args) {
    Optional<String>empty = Optional.empty();
    System.out.println(empty.isPresent());
    System.out.println(empty.isEmpty());


  }

}
