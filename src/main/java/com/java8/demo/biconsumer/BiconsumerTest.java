package com.java8.demo.biconsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class BiconsumerTest {


    public static void main(String[] args) {

        User user = new User();
        Map<String, BiConsumer<User, String>> basicUserSetter =
                Map.of("GR001", (s, v) -> s.setUserName(v)
                        , "GR002", (s, v) -> s.setAddress(v));


        List<TempDataBase> userInfo = List.of(
                new TempDataBase("GR001", "주금석")
                , new TempDataBase("GR002", "010-9655-6150"));


        userInfo.forEach(
                it -> {
                    final var co = basicUserSetter.get(it.getCode());
                    co.accept(user, it.getContents());
                }
        );


        System.out.println(user.getUserName());
        System.out.println(user.getAddress());


        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("1");
        stringArrayList.add("2");
        stringArrayList.add("3");

        stringArrayList.add(0, "5");

        stringArrayList.forEach(System.out::println);
    }
}
