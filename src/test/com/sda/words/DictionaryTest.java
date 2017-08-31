package com.sda.words;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by RENT on 2017-08-31.
 */
public class DictionaryTest {
    private List<String> exampleWords;
    private WordsGenerator wordsGenerator;
    private List<String> substringsWords;
    private Dictionary dictionary;
    @Before
    public void setUp(){

        dictionary = new Dictionary();
        wordsGenerator = new WordsGenerator();
        try {
            exampleWords = wordsGenerator.getWordsList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        substringsWords = createExampleList();
    }

    @Test
    public void shouldReturnSubstrings(){
        List<String> expected = Arrays.asList("Litwo", "Litwin");
        List<String> result = dictionary.getAllContains(substringsWords, "Lit");
        assertEquals(expected,result);
    }
    private List<String> createExampleList(){
        return Arrays.asList("Litwo", "ojczyzno", "moja", "Litwin", "adas");

    }
}