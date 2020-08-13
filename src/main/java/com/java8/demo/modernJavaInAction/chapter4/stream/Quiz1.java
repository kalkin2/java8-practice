/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.java8.demo.modernJavaInAction.chapter4.stream;

import java.util.HashSet;

public class Quiz1 {


  public static void main(String[] args) {
    char[][] temp = {
        {'w', 't', 'e'},
        {'h', 's', 'm'},
        {'s', 'i', 'm'},
        {'w', 'h', 'e'}
    };

    //빈 배열{,,,,,}
    char[] temp2 = new char[temp.length * temp[0].length];
    HashSet<char[]> check = new HashSet<>();

    for (int i = 0; i < temp.length; i++) {
      for (int j = 0; j < temp[i].length; j++) {
        //2차원 배열의 원소를 1차원 배열의 원소로 이동.
        temp2[(i * temp[i].length) + j] = temp[i][j];
        // check.add(temp2);
      }
    }
    check.add(temp2);
    System.out.println(check);
//    String result = Arrays.stream(temp)
//        .flatMap(item -> new String(item).chars().mapToObj(a -> (char) a))
//        .map(s -> s.toString())
//        .distinct()
//        .collect(joining(""));
//    System.out.println(result);
  }

}
