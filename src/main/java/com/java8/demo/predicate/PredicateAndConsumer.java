package com.java8.demo.predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Predicate : boolean 을 리턴하는 서술형 함수
 */
public class PredicateAndConsumer {

  public static void main(String[] args) {
    List<Grape> inventory = Arrays.asList(
        new Grape(70,"green"),
        new Grape(90,"purple"),
        new Grape(120,"red"));

    System.out.println("----1.prediacte...");
    filter(inventory,grape->grape.getWeight()>=100)
        .forEach(System.out::println);
  }

  public static List<Grape> filter(List<Grape> inventory, Predicate<Grape> p) {
    List<Grape> result = new ArrayList<>();
    for (Grape grape : inventory) {
      if (p.test(grape)) {
        result.add(grape);
      }
    }
    return result;
  }

}
