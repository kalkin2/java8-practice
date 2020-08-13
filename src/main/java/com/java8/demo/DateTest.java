/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.java8.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateTest {

  public static void main(String[] args) {

    LocalDate t = LocalDate.of(2015, 4, 17);

    System.out.println(t.atStartOfDay());//2015-04-17T00:00

    System.out.println(LocalDateTime.of(t, LocalTime.MAX));//2015-04-17T23:59:59.999999999

  }
}
