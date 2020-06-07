package com.java8.demo.modernJavaInAction.chapter4.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Stream_Mapping {


    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT)
                , new Dish("beef", false, 700, Dish.Type.MEAT)
                , new Dish("chicken", false, 400, Dish.Type.MEAT)
                , new Dish("french fries", false, 530, Dish.Type.OTHER)
                , new Dish("rice", true, 300, Dish.Type.OTHER)
                , new Dish("season fruit", true, 120, Dish.Type.OTHER)
                , new Dish("pizza", true, 550, Dish.Type.MEAT)
                , new Dish("prawns", false, 300, Dish.Type.FISH)
                , new Dish("salmon", false, 450, Dish.Type.FISH)
        );

        //ex1
        List<String> words = Arrays.asList("Modern", "java", "In", "action");
        List<Integer> wordLength = words.stream()
                .map(String::length)
                .collect(toList());

        System.out.println("wordsLength:" + wordLength);


        //ex2
        List<Integer> dishNames = menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(toList());
        System.out.println("dishName length :" + dishNames);

        //[hello, world] 리스트를 -> "h","e","l","o","w","r","d" 를 만들어 보자
        //ex3-1 list 배열로 만들어져서 실패
        List<String> words2 = Arrays.asList("hello", "world");
        List<String[]> result = words2.stream()
                .map(list -> list.split(""))
                .collect(toList());

        //ex3-2 List<Stream<String>> 로 만들여져서 실패
        List<Stream<String>> result2 = words2.stream()
                .map(word -> word.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(toList());

        System.out.println("result2===" + result2);

        //ex3-3: flatMap을 사용하여 생성된 스트림을 하나의 스트림으로 평면화 한다.,
        List<String> restult3 = words2.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());

        System.out.println("result3==" + restult3);
    }
}
