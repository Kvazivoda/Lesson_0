package org.example;

public class NumberComparator {
    public static String compare(int first, int second) {
        if (first > second) {
            return first + " > " + second;
        } else if (first < second) {
            return first + " < " + second;
        } else {
            return first + " == " + second;
        }
    }

}
