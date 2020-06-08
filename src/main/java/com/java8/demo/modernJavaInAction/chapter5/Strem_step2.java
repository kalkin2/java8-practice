package com.java8.demo.modernJavaInAction.chapter5;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@AllArgsConstructor
@Data
class Dish{
    private String name;
    private final boolean vegetarian;
    private int calories;
    private final Dish.Type type;
    public enum Type {MEAT, FISH, OTHER}

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }
}


public class Strem_step2 {
    public static void main(String[] args) {

        //이미 정렬되어 있는 리스트
         List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit",true,120,Dish.Type.OTHER)
                , new Dish("prawns", false,300,Dish.Type.FISH)
                , new Dish("rice",true,350,Dish.Type.OTHER)
                , new Dish("chicken",false,400,Dish.Type.MEAT)
                 ,new Dish("french fries",true,530,Dish.Type.OTHER)
                 ,new Dish("cola",true,200,Dish.Type.OTHER)


         );
        //메뉴 갯수
        int menuNum =  specialMenu.stream().map(d->1).reduce(0,Integer::sum);
        System.out.println("menuNum :"+menuNum);
        //메뉴 총 칼로리
        int totalCalorie = specialMenu.stream().map(d->d.getCalories()).reduce(0,Integer::sum);
        System.out.println("total :"+totalCalorie);

         List<Dish>filteredMenu = specialMenu.stream()
                 .filter(dish->dish.getCalories() <320)
                 .collect(toList());
        System.out.println("일반적인 필터 사용 "+ filteredMenu);


        //take while 문법 : 원하는 조건까지만   연산 후 중지
        List<Dish>sliceMenu1 = specialMenu
                                .stream()
                                .takeWhile(dish->dish.getCalories()  < 320)
                                .collect(toList());


        System.out.println("takeWhile 사용(JAVA9): "+sliceMenu1);

        //DROPWHILE : TAKE WHILE과 반대
        List<Dish>sliceMenu2 = specialMenu
                .stream()
                .dropWhile(dish->dish.getCalories()  < 320)
                .collect(toList());

        //COLA는 가져오지 않음, 처음으로 거짓이 되는 rice 이전은  버리고 나머지를 모두 담는다
        System.out.println("dropWhile 사용(JAVA9): "+sliceMenu2);


        //요소 건너 뛰기
        List<Dish>dishes = specialMenu.stream()
                .filter(d->d.getCalories()>300)
                .skip(2)
                .collect(toList());
        System.out.println("skip으로 건너뛰기 : "+dishes);

        //5.4 검색과 매칭
        //적어도 한개 이상의 바게타리안이 있는지 찾기
        if(specialMenu.stream().anyMatch(Dish::isVegetarian)){
            System.out.println("vegetarian find!!!!");
        }

        //모든 요소가 모든요소는 같다 1000칼로리 이하이다.
        boolean isHealthy = specialMenu.stream().allMatch(dish->dish.getCalories() < 1000);
        System.out.println("isHealthy :"+isHealthy);

        //위와 같음. 모든요소는 같지 않다 =! 1000칼로리 이상
        boolean isHealthy2 = specialMenu.stream().noneMatch(dish-> dish.getCalories()>=1000);
        System.out.println("isHealthy2 : "+isHealthy2);

        specialMenu.stream()
                .filter(Dish::isVegetarian)
                .findAny();//Optional Return
               // .isPresent(dish -> System.out.println(dish.getName()));


        //제곱근의 값중 3으로 나누어 떨어지는 첫번째 요소 찾기
        List<Integer>someNumbers = Arrays.asList(1,2,3,4,5);
                Optional<Integer> firstSquareDivisiblebyThree = someNumbers.stream()
                        .map(n->n*n) //1,4,9,16,25
                        .filter(n->n % 3 ==0)
                        .findFirst();//9 Optional Return
    }
}
