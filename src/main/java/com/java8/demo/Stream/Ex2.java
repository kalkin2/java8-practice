package com.java8.demo.Stream;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex2 {


    public static void main(String[] args) {
        IntStream.rangeClosed(1,10).forEach(i -> System.out.println(i));
       // Stream.iterate(BigInteger.ONE, i-> i.add(BigInteger.ONE)).forEach(i->System.out.print(i+""));
    }
}
