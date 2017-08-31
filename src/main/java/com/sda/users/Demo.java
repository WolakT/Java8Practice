package com.sda.users;

import java.util.List;

/**
 * Created by RENT on 2017-08-30.
 */
public class Demo {


    public static void main(String[] args) {

        UserGenerator userGenerator = new UserGenerator();

        List<User> list = userGenerator.createRandomUsers(10);
        list.stream().forEach(System.out::println);
        Functions functions = new Functions();
        List<String> names = functions.getAllNames(list);
        names.stream().forEach(System.out::println);
        System.out.println(functions.getMaximumAge(list));
    }
}
