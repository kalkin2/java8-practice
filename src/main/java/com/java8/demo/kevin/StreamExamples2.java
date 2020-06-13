package com.java8.demo.kevin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamExamples2 {


  public static void main(String[] args) {

    //1~10 까지의 숫자중 3이상 9 미만의 값을 추출 하여,
    //2배를 해준 후 에 그값이 10 이상인 첫번째 수를  찾아라.

    //===========================Old==========================
    final List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    final List<Integer> result = new ArrayList<>();
    for (final Integer number : numberList) {
      if (number > 3 && number < 9) {
        final int newNumber = number * 2;
        if (newNumber > 10) {
          result.add(newNumber);
          break;
        }
      }
    }
    System.out.println("case1 " + result);

    //===========================New==========================
    Optional<Integer> result2 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        .filter(i -> i > 3 && i < 9)
        .map(i -> i * 2)
        .filter(i -> i > 10)
        .findFirst();
    System.out.println("case2 " + result2);
  }
}
