package com.java8.demo.Lamda.ex1_lamdaStyle;



import static com.java8.demo.Lamda.ex1_lamdaStyle.Color.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * lamda 표현식으로 수정
 */
public class Ex1 {

  //함수형 인터페이스
  public interface Predicate<T>{

    /**
     * 함수형 인터페이스는 정확히 한개의 메소드만 허용한다.
     * @param t
     * @return
     */
    boolean test(T t);
  }


  public static void main(String[] args) {

    List<Apple> appleList = Arrays.asList(new Apple(80,GREEN)
                                          ,new Apple(155,GREEN)
                                           ,new Apple(200,GREEN)
                                          ,new Apple(120, Color.RED)
                                          ,new Apple(20, Color.RED)
                                          ,new Apple(40, Color.RED)
                                          ,new Apple(300, Color.RED)
                                        );
    //green apple
    List<Apple> greenApples = filter(appleList, (Apple apple)-> GREEN.equals(apple.getColor()));
    //red Apple
    List<Apple> redApples = filter(appleList, (Apple apple)-> RED.equals(apple.getColor()));
    //green apple & 100 over weight
    List<Apple> over100GreenApple = filter(appleList, (Apple apple) -> GREEN.equals(apple.getColor())&& apple.getWeight()>=100);

    System.out.println(greenApples.stream().count());//3
    System.out.println(redApples.stream().count());//4
    System.out.println(over100GreenApple.stream().count());//2
  }


  public static<T>List<T> filter (List<T>list, Predicate<T> p){
    List<T>result = new ArrayList<>();
    for(T e: list){
      if(p.test(e)){
        result.add(e);
      }
    }
    return result;
  }

}
