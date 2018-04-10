package sda.mvn.utils;

import java.util.Arrays;

public class StringCalculator {

    public int sumString(String text) {
        return Arrays.stream(text.replaceAll(",\\s*", ",").split(","))
                .mapToInt(Integer::valueOf)
                .sum();
    }
}
