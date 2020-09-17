package com.java8.demo.optional.optionalCrashCourse;

import java.util.Optional;

public class Exam1 {

  public static void main(String[] args) {

    //빈 Optional의 사용, 초기화 방법
    Optional<String>empty = Optional.empty();
    System.out.println(empty.isPresent());
    System.out.println(empty.isEmpty());

    //값이 있을 경우
    Optional<String>optHello = Optional.of("hello");
    System.out.println(optHello.isPresent());
    System.out.println(optHello.isEmpty());
    System.out.println("orElse:"+optHello.orElse("world"));


    //.of시에 Nulld일경우 바로 NPE 실행됨,
//    Optional<String> nullvalue = Optional.of(null);
//    System.out.println("NPE 실행 됨:"+nullvalue.orElse("world"));


    //OrElse : Null일경우 실행 됨
    Optional<String> nullablevalue = Optional.ofNullable(null);
    System.out.println("Null일경우 실행 됨:"+nullablevalue.orElse("world"));


    //map과 같이 사용
    String orElse = optHello.map(String::toUpperCase)
                            .orElse("world222@@@@@");
    System.out.println("orElse===="+orElse);

    //ifPresentOrElse
    optHello.ifPresentOrElse(System.out::println, ()-> System.out.println("world!!!"));
    nullablevalue.ifPresentOrElse(System.out::println, ()-> System.out.println("world!!!"));




  }

}
