package sda.mvn.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class StringCalculator {

    public int sumString(String text) {
        return StringUtils.isBlank(text) ? 0 :
                Arrays.stream(StringUtils.deleteWhitespace(text).split("[,;]"))
                        .mapToInt(Integer::valueOf)
                        .sum();
    }
}
