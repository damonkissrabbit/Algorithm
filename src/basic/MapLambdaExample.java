package basic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapLambdaExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob");

//        List<String> upperCaseNames = names.stream()
//                .map(name -> name.toUpperCase())
//                .collect(Collectors.toList());

        List<String> upperCaseNames = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        for (String name : upperCaseNames) {
            System.out.println(name);
        }

    }
}
