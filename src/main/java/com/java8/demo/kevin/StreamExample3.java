package com.java8.demo.kevin;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample3 {

  public static void main(String[] args) {

    //ex1. toList
    System.out.println(
        Stream.of(1, 3, 3, 5, 5)
            .filter(i -> i > 2)
            .map(i -> i * 2)
            .map(i -> "#" + i)
            .distinct()
            .collect(Collectors.joining(", ", "[", "]"))
    );
    //ex2. toSet
    System.out.println(
        Stream.of(1, 3, 3, 5, 5)
            .filter(i -> i > 2)
            .map(i -> i * 2)
            .map(i -> "#" + i)
            .collect(toSet())
    );

    //ex3. joining
    System.out.println(
        Stream.of(1, 3, 3, 5, 5)
            .filter(i -> i > 2)
            .map(i -> i * 2)
            .map(i -> "#" + i)
            .collect(Collectors.joining(", ", "[", "]"))
    );

    //ex4. distinct + joining
    System.out.println(
        Stream.of(1, 3, 3, 5, 5)
            .filter(i -> i > 2)
            .map(i -> i * 2)
            .map(i -> "#" + i)
            .distinct()
            .collect(Collectors.joining(", ", "[", "]"))
    );

    //ex5. distinc + toList
    System.out.println(
        Stream.of(1, 3, 3, 5, 5)
            .filter(i -> i > 2)
            .map(i -> i * 2)
            .map(i -> "#" + i)
            .distinct()
            .collect(toList())
    );

    System.out.println(
        Stream.of(1, 3, 3, 5, 5)
            .filter(i -> i == 3)
            .findFirst()
    );
  }

}
