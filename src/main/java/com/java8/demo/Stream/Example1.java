/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.java8.demo.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * https://futurecreator.github.io/2018/08/26/java-8-streams/
 */
public class Example1 {


  public static void main(String[] args) {
    //배열 스트림
    String[] array = new String[]{"a", "b", "c"};

    //배열을 스트림으로 생성
    Stream<String> stream = Arrays.stream(array);

    //베얄 idx 로 뽑아내기
    Stream<String> StreamOfArrayPart = Arrays.stream(array, 1, 3);// idx 1이상 3미만
    StreamOfArrayPart.forEach(System.out::println);

    //Stream.generate()
    Stream<String> generatedStream =
        Stream.generate(() -> "go").limit(5); // [el, el, el, el, el]
    generatedStream.forEach(System.out::println);

    //30 부터 2씩 증가하면서 5개 생성
    Stream<Integer> newNumList = Stream.iterate(30, n -> n + 2).limit(5);
    newNumList.forEach(System.out::println);

    IntStream intStream = IntStream.range(1, 5); // [1, 2, 3, 4]
    IntStream longStream = IntStream.rangeClosed(1, 5);//// [1, 2, 3, 4, 5]

    DoubleStream doubles = new Random().doubles(3); // 난수 3개 생성
    doubles.forEach(System.out::println);

    IntStream charsStream =
        "Stream".chars(); // [83, 116, 114, 101, 97, 109]

    //특정문자열로 자르고 배열로 Stream으로 저장
    Stream<String> stringStream =
        Pattern.compile(", ").splitAsStream("Eric, Elena, Java");
    // [Eric, Elena, Java]

    //list 로 저장
    List<String> aaa = Pattern.compile(", ").splitAsStream("Eric, Elena, Java")
        .collect(Collectors.toList());
    System.out.println("new List : " + aaa);
  }

}
