package com.sda.users;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by RENT on 2017-08-31.
 */
public class FunctionsTest {

    private List<User> exampleUserList;
    private Functions functions;
    @Before
    public void setUp(){
        exampleUserList = createList();
        functions = new Functions();
    }

    @Test
    public void shouldReturnAllNames(){
        List<String> result = functions.getAllNames(exampleUserList);

        List<String> expected = Arrays.asList("Aga", "Zenon", "Franek");

//        Assert.assertArrayEquals(expected,result);
        Assert.assertEquals(expected,result);

    }

    @Test
    public void shouldReturnNullIfTheListIsEmpty(){
        List<User> input = new ArrayList<>();
        List<String> result = functions.getAllNames(input);

        Assert.assertEquals(null, result);
    }

    @Test
    public void shouldReturnMapWithIds(){
        Map<Integer, User> result = functions.groupById(exampleUserList);
        Map<Integer,User> expected = new HashMap<>();
        expected.put(exampleUserList.get(0).getId(), exampleUserList.get(0));
        expected.put(exampleUserList.get(1).getId(), exampleUserList.get(1));
        expected.put(exampleUserList.get(2).getId(), exampleUserList.get(2));

        Assert.assertEquals(expected, result);

    }

    @Test
    public void shouldJoinNames(){
        String expected = "Aga | Zenon | Franek";
        String result = functions.joinNamesByDelimiter(exampleUserList," | ");

        Assert.assertEquals(expected,result);
    }

    @Test
    public void shouldReturnListOfSkills(){
        List<String> expected = Arrays.asList("Python", "Java", "Scala",
                "Python", "Java", "Scala",
                "Python", "Java", "Scala"
                );
        List<String> result = functions.getAllSkills(exampleUserList);

        assertEquals(expected,result);
     }

     @Test
     public void shouldReturnDistinctSetOfSkills(){
        Set<String> expected = new HashSet<>();
        expected.add("Python");
        expected.add("Java");
        expected.add("Scala");

        Set<String> result = functions.getUniqueSkills(exampleUserList);
        assertEquals(expected, result);
     }

    private List<User> createList(){
        List<User> list = new ArrayList<>();
        List<String> skills = Arrays.asList("Python", "Java", "Scala");
        list.add(new User(1,"Aga", 34, skills));
        list.add(new User(2,"Zenon", 40, skills));
        list.add(new User(3,"Franek", 23,skills));

        return list;
    }


}