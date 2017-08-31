package com.sda.lambdas;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Demo {

    public static void main(String[] args) {


        Function<Integer, Integer> increment = x -> x + 1;
        Integer i = 10;
        Integer result = increment.apply(i);
        System.out.println(result);


        Predicate<Integer> even = n -> n % 2 == 0;
        IntStream.range(0,10).boxed().filter(even).forEach(System.out::println);




    }
}
