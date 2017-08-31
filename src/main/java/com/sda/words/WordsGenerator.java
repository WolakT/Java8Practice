package com.sda.words;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by RENT on 2017-08-31.
 */
public class WordsGenerator {

    public List<String> getWordsList() throws IOException {
        return Files.readAllLines(Paths.get("C:\\Users\\RENT\\Documents\\Java8\\Java8practice\\src\\main\\java\\com\\sda\\resources\\dictionary.txt"));
    }
}
