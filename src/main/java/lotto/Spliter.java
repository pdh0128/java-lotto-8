package lotto;

import java.util.Arrays;
import java.util.List;

public class Spliter {

    public static List<Integer> split(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();
    }
}
