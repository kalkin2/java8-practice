package com.java8.demo.modernJavaInAction.chapter4.stream;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Quize {

    public static void main(String[] args) {
        //1. [1,2,3,4,5] 제곱은으로 반환하시오 . [1,4,9,16,26]
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        List<Integer> doubleNumbers= numbers.stream()
                .map(s->s*s)
                .collect(toList());
        System.out.println("doubleNumbers=="+doubleNumbers);

        //2.두개의 숫자 리스트가 있을때 모든 숫자 쌍의 리스트를 반환하시오
        //[1,2,3]과 [3,4] [(1,3),(1,4),(2,3),(2,4),(3,3),(3,4)
        List<Integer>numbers1 = Arrays.asList(1,2,3);
        List<Integer>numbers2 = Arrays.asList(3,4);
        List<int[]>pairs = numbers1.stream()
                .flatMap(i -> numbers2
                                .stream()
                                .filter(j->(i+j)%3==0)//합이 3으로 나누어 떨어지는 쌍만 반환하기
                                .map(j->new int[] {i,j}))
                .collect(toList());

        System.out.println(pairs);


    }
}
