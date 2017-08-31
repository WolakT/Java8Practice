package com.sda.users;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by RENT on 2017-08-30.
 */
public class Functions {

    public List<String> getAllNames(List<User> list) {
        if(list.size()>0)
        return list.stream().map(user -> user.getName()).collect(Collectors.toList());
        else return null;
    }

    public List<String> getUniqueNames(List<User> list) {
        return list.stream().map(user -> user.getName()).distinct().collect(Collectors.toList());
    }

    public double getAverageAge(List<User> list) {
        int sum = 0;
        double count = list.stream().map(user -> user.getAge()).count();
        return 0;
    }

    public Integer getMaximumAge(List<User> list) {
        return list.stream().map(User::getAge).max(Integer::compareTo).orElse(-1);

    }

    public Integer getMinimumAge(List<User> list){
        return list.stream().map(User::getAge).min(Integer::compareTo).orElse(-1);
    }

    Function<User,Map<Integer,User>> groupIds = (user) -> {
        Map<Integer,User> map = new HashMap<>();
        map.put(user.getId(),user);
        return map;
    };


    public Map<Integer, User> groupById(List<User> list){
        return list.stream().collect(Collectors.toMap(User::getId,user -> user));
    }

    public String joinNamesByDelimiter(List<User> list, String delimiter){
        return list.stream().map(User::getName).collect(Collectors.joining(delimiter));
    }

    public List<String> getAllSkills(List<User> list){
        return list.stream().map(User::getSkills).flatMap(List::stream).collect(Collectors.toList());
    }

    public Set<String> getUniqueSkills(List<User> list){
        if(list.size()>0){
            return list.stream().map(User::getSkills).flatMap(List::stream).collect(Collectors.toSet());
        }
        else return null;
    }


}
