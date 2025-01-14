package src.main.stream.api;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SecondHighestNumber {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 3, 9, 7, 1);

        Optional<Integer> secondHighest = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .skip(1)
                .findFirst();

        System.out.println("Second Highest: " + secondHighest.orElse(-1));
    }

}
