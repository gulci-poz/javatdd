package sda.mvn.service;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        //
        // regex version
        //

        String content;

        if (StringUtils.isBlank(name)) {
            content = "my friend";
        } else {
            content = name.contains(",") ?
                    name.replaceAll("(,\\s*)(\\w+$)", " and $2") : name;
        }

        return content;

        //
        // substring version
        //

        //String content;
        //
        //if (StringUtils.isBlank(name)) {
        //    content = "my friend";
        //} else if (!name.contains(",")) {
        //    content = name;
        //} else {
        //    content = name.substring(0, name.lastIndexOf(",")) + " and" +
        //            name.substring(name.lastIndexOf(",") + 1, name.length());
        //}
        //
        //return content;

        //
        // step-by-step version
        //

        //String content;
        //
        //if (StringUtils.isBlank(name)) {
        //    content = "my friend";
        //} else {
        //    String[] names = name.split(", ");
        //
        //    if (names.length > 1) {
        //        StringBuilder andString = new StringBuilder();
        //
        //        for (int i = 0; i < names.length; i++) {
        //            // in all cases we want to append the name
        //            andString.append(names[i]);
        //
        //            if (i == names.length - 2) {
        //                // after second to last
        //                andString.append(" and ");
        //            } else if (i != names.length - 1) {
        //                // after each name, except the second to last and the last
        //                andString.append(", ");
        //            }
        //        }
        //
        //        content = andString.toString();
        //    } else {
        //        // one name
        //        content = name;
        //    }
        //}
        //
        //return content;
    }

    private static String suffix(String name) {
        return isCapitalizedName(name) ? "!" : ".";
    }

    private static boolean isCapitalizedName(String name) {
        // blanks and comas are copied in toUpperCase()
        return (StringUtils.isNotBlank(name) && name.toUpperCase().equals(name));
    }
}
