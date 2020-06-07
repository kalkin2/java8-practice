package com.java8.demo.modernJavaInAction.chapter4.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

import static java.util.stream.Collectors.toList;

@AllArgsConstructor
@Data
class Dish{
    private String name;
    private final boolean vegetarian;
    private int calories;
    private final Type type;
    public enum Type {MEAT, FISH, OTHER}

}
public class Stream_Basic {


    public static void main(String[] args) {
        List<Dish> lowCaloricDishes = new ArrayList<>();
        List<Dish> menu = Arrays.asList(
                new Dish("pork",false,800,Dish.Type.MEAT)
                , new Dish("beef", false,700,Dish.Type.MEAT)
                , new Dish("chicken",false,400,Dish.Type.MEAT)
                , new Dish("french fries",false,530,Dish.Type.OTHER)
                , new Dish("rice",true,300,Dish.Type.OTHER)
                , new Dish("season fruit",true,120,Dish.Type.OTHER)
                , new Dish("pizza",true,550,Dish.Type.MEAT)
                , new Dish("prawns",false,300,Dish.Type.FISH)
                , new Dish("salmon", false,450,Dish.Type.FISH)
        );

        for(Dish dish : menu){
            if(dish.getCalories() <400){
                lowCaloricDishes.add(dish);
            }
        }

        Collections.sort(lowCaloricDishes, new Comparator<Dish>(){
            public int compare(Dish dish1, Dish dish2){
                return Integer.compare(dish1.getCalories(), dish2.getCalories());
            }
        });

        List<String> lowCaloricDishesName = new ArrayList<>();
        for(Dish dish:lowCaloricDishes){
            lowCaloricDishesName.add(dish.getName());
        }

        System.out.println("java8 Before ====> "+lowCaloricDishesName);


        //java8 : 400칼로리 이하의 저칼로리 음식 찾기
        List<String> lowCaloricDishesName2 = menu.stream()
                .filter(d->d.getCalories()<400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());

        System.out.println("java8 Lamda===> "+lowCaloricDishesName2);


        //고칼리로 음식 3개 찾기
       menu.stream()
                .filter(d->d.getCalories()>400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(d-> {
                    System.out.println("400이상 칼로리 검색됨 : "+d.getCalories());
                    return d.getName();
                })
                .limit(3)
               //.collect(toList());
               .forEach(System.out::println);//바로 출력하기
        //forEach를 제외한 나머지는 STREAM을 리턴한다
        //마지막 forEach는 Stream을 리턴하지 않으므로  최종 연산
    }

}
