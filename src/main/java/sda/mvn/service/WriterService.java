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
        String content;

        if (StringUtils.isBlank(name)) {
            content = "my friend";
        } else {
            if (name.contains(",")) {
                String and = isCapitalizedName(name) ? " AND " : " and ";
                content = name.replaceAll("(,\\s*)(\\w+$)", and + "$2");
                content = content.replaceAll("\\s+", " ");
                content = content.replaceAll(",\\b", ", ");
            } else {
                content = name;
            }
        }

        return content;
    }

    private static String suffix(String name) {
        return isCapitalizedName(name) ? "!" : ".";
    }

    private static boolean isCapitalizedName(String name) {
        // blanks and comas are copied in toUpperCase()
        return (StringUtils.isNotBlank(name) && name.toUpperCase().equals(name));
    }
}
