package src.main.stream.api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlattenList {

    public static void main(String[] args) {
        List<List<Integer>> nestedList = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4));
        List<Integer> flatList = nestedList.stream()
                .flatMap(List::stream)
                .toList();
        System.out.println("Flattened List: " + flatList);
    }

}



