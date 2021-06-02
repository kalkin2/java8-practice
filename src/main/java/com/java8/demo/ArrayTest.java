package com.java8.demo;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ArrayTest {

    public void arraysInputFunc(String... fruit){
        List<String> fruitList = Arrays.asList(fruit);
        fruitList.forEach(System.out::println);
    }

    @Test
    public void fruitTest(){
        this.arraysInputFunc("apple","banana","orange");
    }


}
