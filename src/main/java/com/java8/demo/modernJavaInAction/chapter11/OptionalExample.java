/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.java8.demo.modernJavaInAction.chapter11;


import java.util.Optional;

public class OptionalExample {


  public static void main(String[] args) {

    Person person = new Person();
    //빈 optional
    Optional<Car> optCar = Optional.empty();

    //Null 이 아닌 값으로 Optional 만들기
    Car car = new Car();
    Optional<Car> optionalCar = Optional.of(car);

    //Null일 수도 있는 값으로 Optional 만들기, car 가 null 이면 빈 Optional이 반환된다.
    // Optional<Car> optionalCar1 = Optional.ofNullable(car);

    //ofNullable 로 null일수도 있는 값을 Optional.empty로 바꿔준다.
    //이경우 .map을 했을경우 해당객체가 비어있으면 아무일도 일어 나지 않는다.
    Insurance insurance = null;
    Optional<Insurance> optionalInsurance = Optional.ofNullable(insurance);
    System.out.println("optionalInsurance==" + optionalInsurance);
    //optionalInsurance 가 비어있으면 아무런 일도 일어 나지 않는다.
    optionalInsurance.map(Insurance::getName);

    //flatMap으로 Optional객체 연결
    Optional<Person> optionalPerson = Optional.of(person);
//    Optional<String> name = optionalPerson
//        .map(Person::getCar)
//        .map(Car::getInsurance)
//        .map(Insurance::getName);

    //중첩 Optional벗겨내기
//    optionalPerson
//        .flatMap(Person::getCar)
//        .flatMap(Car::getInsurance)
//        .map(Insurance::getName);
  }

}
