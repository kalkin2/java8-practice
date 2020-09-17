package com.java8.demo.modernJavaInAction.chapter5;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreamExample {

  public static void main(String[] args) {

    /**
     * iterator는 predicate(true or false)를 지원한다.
     * 아래처럼 0에서 시작해서 100보다 크면 숫자 생성을 중단하는 코드를 구현할 수 있다.
     */

    //ex1
    IntStream.iterate(0,n->n<100, n->n+4)
        .forEach(System.out::println);


    //ex2. takeWhile 활용
    //takeWhile: 특정한 엘리먼트까지 왔다면 멈추고 그 엘리먼트까지 반환한다. Predicate을 파라미터로 받으니 boolean 값을 리턴하면 된다.
    IntStream.iterate(0,n->n+4)
        .takeWhile(n->n<100)
        .forEach(System.out::println);


    //잘못된예 (무한으로 생성됨)
  /*
      IntStream.iterate(0,n->n+4)
          .filter(n->n<100)
          .forEach(System.out::println);
  */

    Stream.generate(Math::random)
        .limit(5)
        .forEach(System.out::println);

  }

}
