package com.java8.demo.modernJavaInAction.chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reduce {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);

        //old Style
        int sum = 0;
        for (int i :numbers){
            sum += i;
        }
        System.out.println("sum=="+sum);

        //reduce 이용

        int result = numbers.stream()
                //.reduce(0,(a,b)->a+b);
                .reduce(0,Integer::sum);//lamda Style

        System.out.println("reduce를 이용한 합계 "+result);

        //최대값
        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        Optional<Integer> min = numbers.stream().reduce(Integer::min);

        System.out.println("최대값 : "+max);
        System.out.println("최소값 : "+min);


    }
}
