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
        // todo try with lambdas

        String content;

        if (StringUtils.isBlank(name)) {
            content = "my friend";
        } else {
            String[] names = name.split(", ");
            StringBuilder andString = new StringBuilder();

            if (names.length > 1) {
                for (int i = 0; i < names.length; i++) {
                    if (i == names.length - 1) {
                        // before last name
                        andString.append(" and ");
                    } else if (i != 0) {
                        // before each non-first and non-last name
                        andString.append(", ");
                    }
                    // in all cases we want a name
                    andString.append(names[i]);
                }

                content = andString.toString();
            } else {
                // one name
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
