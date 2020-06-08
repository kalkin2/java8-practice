package com.java8.demo.modernJavaInAction.chapter5.Trader;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class MainClass {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        //거래자 == TRADER

        //1. 2011년에 일어난 모든 트랜젝션을 찾아 값을 오름차순으로 정리 하시오
        List<Transaction> transaction2011 = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(toList());

        System.out.println("2011년에 일어난 모든 트랜잭션 :" + transaction2011);

        //2. 거래자가 근무하는 모든 도시를 중복없이 나열하시오
        List<String> result = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(toList());

        System.out.println("거래자가 근무하는 모든 도시를 중복없이 나열 " + result);

        //3. 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬 하시오
        List<Trader> personList = transactions.stream()
                .map(t -> t.getTrader())
                .filter(t -> t.getCity().equals("Cambridge"))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(toList());

        System.out.println("케임브릿지에서 근무하는 모든 근무자를 이름순으로 정렬 :" + personList);

        //4. 모든 거래자의 이름을 알파벳순으로 정렬해서 반환하시오
        List<String > traderName = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .collect(toList());
        System.out.println("traderName======" + traderName);
        //정답1
       String traderName2 = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("",(n1,n2) -> n1+n2);
        System.out.println("traderName2======" + traderName2);

        //정답2:joining을 활용
        String traderName3 = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining());
        System.out.println("traderName3======" + traderName3);
        //5. 밀라노에 거래자가 있는가?

        boolean existMilanTrader = transactions.stream()
                //.filter(t->t.getTrader().getCity().equals("Milan"))
                .anyMatch(t->t.getTrader().getCity().equals("Milan"));
        System.out.println("existMilanTrader==="+existMilanTrader);


        //6. 케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력하시오

       List<Integer>allTran= transactions.stream()
                .filter(trader->trader.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .collect(toList());
        System.out.println("allTran"+allTran);

        //7. 전체 트랜잭션중 최댓값은 얼마인가?
        Optional<Integer> max = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);

        System.out.println("거래 최대값 :"+max);

        //8 전체 트랜잭션 중 최소값은 얼마인가?
        //오답?
        Optional<Integer>min = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min);
        System.out.println("거래 최소값1 : "+min);

        //정답
        Optional<Transaction>min2 = transactions.stream()
                .reduce((t1,t2)->t1.getValue()<t2.getValue() ? t1 : t2);
        System.out.println("거래 최소값2 : "+min2);

        //min메소드를 이용
        Optional<Transaction> smallestTrans = transactions.stream()
                .min(comparing(Transaction::getValue));
        System.out.println("거래최소값3 :"+smallestTrans);



    }
}
