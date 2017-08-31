package com.sda.words;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by RENT on 2017-08-31.
 */
public class Dictionary {

    public List<String> getAllContains(List<String> words, String substring){

        if (words.size()>0){
            return words.stream().filter(s -> s.contains(substring)).collect(Collectors.toList());
        }
        else return null;
    }

    public List<String> getAllLength(List<String> words, int length){
        if(words.size()>0){
            return words.stream().filter(s -> s.length()==length).collect(Collectors.toList());
        }
        return null;
    }

}
