package com.sda.users;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by RENT on 2017-08-30.
 */
public class UserGenerator {
    private List<String> names;
    private List<String> skills;

    public UserGenerator() {
        String fileName = "C:\\Users\\RENT\\Documents\\Java8\\project\\src\\main\\java\\com\\sda\\resources\\imiona.txt";

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            names = stream.collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        skills = Arrays.asList("SQL", "Java", "Python", "Kotlin", "Scala");


    }

//    Function<String, User> mapToUser = (string) -> {
//        User user = new User();
//        user.setName(string);
//        return user;
//    };


    List<User> createRandomUsers(int n) {
        Random random = new Random();
        random.nextInt(names.size());

        return IntStream.range(1, n).boxed()
                .map(i -> createUser(names.get(random.nextInt(names.size())), random.nextInt(40)+18, getRandomSkills(5), i))
                .collect(Collectors.toList());

    }

    private User createUser(String name, int age, List<String> skills, int id) {

        return new User(id, name, age, skills);
    }


    private List<String> getRandomSkills(int n) {
        List<String> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            list.add(skills.get(random.nextInt(skills.size())));
        }

        return list.stream().distinct().collect(Collectors.toList());

    }
}
