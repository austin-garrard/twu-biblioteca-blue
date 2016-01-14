package com.twu.biblioteca;

public class Formatter {

    public String formatSubstring(String substring, int limit) {

        String formattedSubstring;

        if (substring.length() > limit) {
            formattedSubstring = substring.substring(0,limit);
            formattedSubstring += "...  ";
        } else {
            formattedSubstring = padString(substring, limit);
        }

        return formattedSubstring;
    }

    private String padString(String string, int limit) {
        String paddedString = string;

        for (int i = string.length(); i < limit + 5; i++) {
            paddedString += " ";
        }

        return paddedString;
    }
}
