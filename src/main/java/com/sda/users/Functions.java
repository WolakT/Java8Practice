package com.sda.users;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by RENT on 2017-08-30.
 */
public class Functions {

    public List<String> getAllNames(List<User> list) {
        return list.stream().map(user -> user.getName()).collect(Collectors.toList());
    }

    public List<String> getUniqueNames(List<User> list) {
        return list.stream().map(user -> user.getName()).distinct().collect(Collectors.toList());
    }

    public double getAverageAge(List<User> list) {
        double count = list.stream().map(user -> user.getAge()).count();
        return 0;
    }

    public Integer getMaximumAge(List<User> list) {
        return list.stream().map(User::getAge).max(Integer::compareTo).orElse(-1);

    }

}
