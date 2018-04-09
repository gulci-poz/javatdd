package sda.mvn.service;

import org.apache.commons.lang3.StringUtils;

public class WriterService {

    public String write(String name) {
        return composeGreeting(name);
    }

    private static String composeGreeting(String name) {
        return prefix(name) + content(name) + suffix(name);
    }

    private static String prefix(String name) {
        return isCapitalizedName(name) ? "HELLO, " : "Hello, ";
    }

    private static String content(String name) {
        return StringUtils.isBlank(name) ? "my friend" : name;
    }

    private static String suffix(String name) {
        return isCapitalizedName(name) ? "!" : ".";
    }

    private static boolean isCapitalizedName(String name) {
        return (StringUtils.isNotBlank(name) && name.toUpperCase().equals(name));
    }
}
