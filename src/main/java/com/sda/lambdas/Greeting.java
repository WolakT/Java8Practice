package com.sda.lambdas;


public interface Greeting {

   default void sayGreeting(String greeting){
       System.out.println(greeting);
    }

}


















