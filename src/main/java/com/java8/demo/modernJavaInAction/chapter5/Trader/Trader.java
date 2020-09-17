package com.java8.demo.modernJavaInAction.chapter5.Trader;


import lombok.Getter;

@Getter
public class Trader {
  private String name;
  private String city;


  public Trader(String name, String city) {
    this.name = name;
    this.city = city;
  }
}
