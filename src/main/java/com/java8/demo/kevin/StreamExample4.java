package com.java8.demo.kevin;

import static java.util.stream.Collectors.joining;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.AllArgsConstructor;
import lombok.Data;

public class StreamExample4 {


  public static void main(String[] args) {

    final List<Product> products = Arrays.asList(
        new Product(1L, "A", new BigDecimal("100.50")),
        new Product(2L, "B", new BigDecimal("23.50")),
        new Product(3L, "C", new BigDecimal("31.50")),
        new Product(4L, "D", new BigDecimal("80.50")),
        new Product(5L, "E", new BigDecimal("7.50"))
    );
    System.out.println("1. price 30 이상 만 조회 : " +
        products.stream()
            .filter(p -> p.getPrice().compareTo(new BigDecimal("30")) >= 0)
            .collect(Collectors.toList())
    );

    System.out.println("2. price 30 이상 만 조회 : \n" +
        products.stream()
            .filter(p -> p.getPrice().compareTo(new BigDecimal("30")) >= 0)
            .map(p -> p.toString())
            .collect(joining("\n"))
    );

    //Instream을 이용한 합계 구하기
    System.out.println("sum = " + IntStream.of(1, 2, 3, 4, 5).sum());

    //reduce를 이용한 합계 구하기
    System.out.println("total price : " +
        products.stream()
            .map(p -> p.getPrice())
            //.reduce(BigDecimal.ZERO, (product1,product2) -> product1.getPrice().add(product2.getPrice()));
            .reduce(BigDecimal.ZERO, (price1, price2) -> price1.add(price2))
    );

    System.out.println("80 over total price : " +
            products.stream()
                .filter(p -> p.getPrice().compareTo(new BigDecimal("80")) >= 0)
                .map(p -> p.getPrice())
                .reduce(BigDecimal.ZERO, (price1, price2) -> price1.add(price2))
        //.reduce(BigDecimal.ZERO, (product1,product2) -> product1.getPrice().add(product2.getPrice()));
    );

    System.out.println("80 over total count : " +
        products.stream()
            .filter(p -> p.getPrice().compareTo(new BigDecimal("80")) >= 0)
            .map(p -> p.getPrice())
            .count()
    );

    //

    final OrderItem item1 = new OrderItem(1L, products.get(0), 1);
    final OrderItem item2 = new OrderItem(2L, products.get(2), 3);
    final OrderItem item3 = new OrderItem(3L, products.get(4), 10);

    // final Order order = new Order(1L,Arrays.asList(item1,item2,item3));
    final Order order = new Order(1L, Arrays.asList(item1, item2, item3));
    System.out.println("제품 총 가격 계산  = " + order.totalPrice());
  }
}

@AllArgsConstructor
@Data
class Product {

  private Long id;
  private String name;
  private BigDecimal price;
}

@AllArgsConstructor
@Data
class OrderItem {

  private Long id;
  private Product product;
  private int quantity;

  public BigDecimal getTotalPrice() {
    return product.getPrice().multiply(new BigDecimal(quantity));
  }
}

@AllArgsConstructor
@Data
class Order {

  private Long id;
  private List<OrderItem> item;

  public BigDecimal totalPrice() {
    return item.stream()
        .map(item -> item.getTotalPrice())
        .reduce(BigDecimal.ZERO, BigDecimal::add);
    //.reduce(BigDecimal.ZERO,(price1,price2)->price1.add(price2));//위 코드와 같은내용
  }
}

