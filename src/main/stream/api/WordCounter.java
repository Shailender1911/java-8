package src.main.stream.api;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordCounter {
    public static void main(String[] args) {
        String sentence = "Java is fun and Java is powerful";

        Map<String, Long> wordCount = Arrays.stream(sentence.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        wordCount.forEach((word, count) -> System.out.println(word + ": " + count));
    }
}
