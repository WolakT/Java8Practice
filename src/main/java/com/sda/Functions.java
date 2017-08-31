package com.sda;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Functions {

    public static void main(String[] args) {

        showIncrement();
        showPredicate();
        showSupplier();
        showMathOperation();
        showDefaultInInterface();
        showStream();
        mapExample();
        flatMapExample();
        ofNullable();
    }


    public static void showIncrement() {
        //Nowy sposob
        Function<Integer, Integer> increment = x -> x + 1;
        int i = 10;
        System.out.println("Wywoluje funkcje : " + increment.apply(i));

        //Stary tez dobry, a moze nawet lepszy
        i = 10;
        System.out.println("Inkrementacja:  " + (++i));

    }


    public static void showPredicate() {

        Predicate<String> evenCharacter = s -> s.length() % 2 == 0;
        String even = "Even";
        String odd = "Odd";

        System.out.println("'Even' has even number of characters: " + evenCharacter.test(even));
        System.out.println("'Odd' has even number of characters: " + evenCharacter.test(odd));

    }


    public static void showSupplier() {
        Supplier<Double> constant = () -> Math.PI;
        System.out.println("Get value from out supplier : " + constant.get());
    }

    public static void showMathOperation() {

        Function<Integer, Integer> f = x -> 2 * x + 1;
        Function<Integer, Integer> g = x -> 5 * x - 3;
        Function<Integer, Integer> h = x -> g.compose(f).apply(x);

        System.out.println("h(2)" + h.apply(2));

    }


    public static void showDefaultInInterface() {
        new ConcreteMessage().showMessage();
    }

    private static interface Message {
        default void showMessage() {
            System.out.println("This is default method");
        }
    }

    private static class ConcreteMessage implements Message {

    }


    public static void showStream() {

        Arrays.asList("j", "a", "v", "a").forEach(e -> System.out.print(e));
        System.out.println();

        Arrays.asList("j", "a", "v", "a").forEach(System.out::print);
    }

    public static void mapExample() {

        Stream.of("some", "other", "an", "cat", "nie mowie po angielsku")
                .map(s -> s.length())
                .forEach(System.out::print);



        System.out.println();

    }

    public static void flatMapExample() {
        List<List<Integer>> nestedList = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));
        List<Integer> flattenList = nestedList.stream().flatMap(List::stream).collect(Collectors.toList());
        flattenList.forEach(System.out::print);
        System.out.println();
    }

    public static void ofNullable() {
        Optional<String> optional = Optional.ofNullable("Some value");

        System.out.println("is present: " + optional.isPresent());
        System.out.println("get value: " + optional.get());
    }

}
