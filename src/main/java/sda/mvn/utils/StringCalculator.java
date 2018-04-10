package sda.mvn.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class StringCalculator {

    public int sumString(String text) {
        return StringUtils.isBlank(text) ? 0 :
                Arrays.stream(text.replaceAll("\\s*([,;])\\s*", "$1").split("[,;]"))
                        .mapToInt(Integer::valueOf)
                        .sum();
    }
}
