package net.thumbtack.school.base;

import java.util.Arrays;
import java.util.HashSet;
import java.util.StringJoiner;

public class StringOperations {

    public static int getSummaryLength(String[] strings) {
        StringBuilder sb = new StringBuilder();
        for (String elem : strings) {
            sb.append(elem);
        }
        return sb.length();
    }

    public static String getFirstAndLastLetterString(String string) {
        StringBuilder sb = new StringBuilder();
        sb.append(string.substring(0, 1));
        sb.append(string.substring(string.length() - 1));
        return String.valueOf(sb);
    }

    public static boolean isSameCharAtPosition(String string1, String string2, int index) {
        return string1.charAt(index) == string2.charAt(index);
    }

    public static boolean isSameFirstCharPosition(String string1, String string2, char character) {
        return string1.indexOf(character) == string2.indexOf(character);
    }

    public static boolean isSameLastCharPosition(String string1, String string2, char character) {
        return string1.lastIndexOf(character) == string2.lastIndexOf(character);
    }

    public static boolean isSameFirstStringPosition(String string1, String string2, String str) {
        return string1.indexOf(str) == string2.indexOf(str);
    }

    public static boolean isSameLastStringPosition(String string1, String string2, String str) {
        return string1.lastIndexOf(str) == string2.lastIndexOf(str);
    }

    public static boolean isEqual(String string1, String string2) {
        return string1.equals(string2);
    }

    public static boolean isEqualIgnoreCase(String string1, String string2) {
        return string1.toLowerCase().equals(string2.toLowerCase());
    }

    public static boolean isLess(String string1, String string2) {
        return string1.compareTo(string2) < 0;
    }

    public static boolean isLessIgnoreCase(String string1, String string2) {
        return string1.toLowerCase().compareTo(string2.toLowerCase()) < 0;
    }

    public static String concat(String string1, String string2) {
        return string1.concat(string2);
    }

    public static boolean isSamePrefix(String string1, String string2, String prefix) {
        return string1.indexOf(prefix) == string2.indexOf(prefix);
    }

    public static boolean isSameSuffix(String string1, String string2, String suffix) {
        return string1.substring(string1.length() - suffix.length()).equals(string2.substring(string2.length() - suffix.length()));
    }

    public static String getCommonPrefix(String string1, String string2) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < string1.length() && i < string2.length(); i++) {
            if (string1.charAt(i) == string2.charAt(i)) {
                sb.append(String.valueOf(string1.charAt(i)));
            } else {
                return String.valueOf(sb);
            }
        }
        return String.valueOf(sb);
    }

    public static boolean isPalindrome(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != string.charAt(string.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeIgnoreCase(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (string.toLowerCase().charAt(i) != string.toLowerCase().charAt(string.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static String getLongestPalindromeIgnoreCase(String[] strings) {
        HashSet<String> countryHashSet = new HashSet<>(Arrays.asList(strings));
        for (String str : countryHashSet) {
            if (isPalindromeIgnoreCase(String.valueOf(str))) {
                return String.valueOf(str);
            }
        }
        return "";
    }

    public static boolean hasSameSubstring(String string1, String string2, int index, int length) {
        return (getCommonPrefix(string1.substring(index), string2.substring(index)).length() == length);
    }

    public static boolean isEqualAfterReplaceCharacters(String string1, char replaceInStr1, char replaceByInStr1, String string2, char replaceInStr2, char replaceByInStr2) {
        return string1.replace(replaceInStr1, replaceByInStr1).compareTo(string2.replace(replaceInStr2, replaceByInStr2)) == 0;
    }

    public static boolean isEqualAfterReplaceStrings(String string1, String replaceInStr1, String replaceByInStr1, String string2, String replaceInStr2, String replaceByInStr2) {
        return string1.replace(replaceInStr1, replaceByInStr1).compareTo(string2.replace(replaceInStr2, replaceByInStr2)) == 0;
    }

    public static boolean isPalindromeAfterRemovingSpacesIgnoreCase(String string) {
        return isPalindromeIgnoreCase(string.replace(" ", ""));
    }

    public static boolean isEqualAfterTrimming(String string1, String string2) {
        return string1.trim().compareTo(string2.trim()) == 0;
    }

    public static String makeCsvStringFromInts(int[] array) {
        StringJoiner sb = new StringJoiner(",");
        for (int i = 0; i < array.length; i++) {
            sb.add(String.valueOf(array[i]));
        }
        return String.valueOf(sb);
    }

    public static String makeCsvStringFromDoubles(double[] array) {
        StringJoiner sb = new StringJoiner(",");
        for (int i = 0; i < array.length; i++) {
            sb.add(String.format("%.2f", array[i]));
        }
        return String.valueOf(sb);
    }

    public static StringBuilder makeCsvStringBuilderFromInts(int[] array) {
        return new StringBuilder(makeCsvStringFromInts(array));
    }

    public static StringBuilder makeCsvStringBuilderFromDoubles(double[] array) {
        return new StringBuilder(makeCsvStringFromDoubles(array));
    }

    public static StringBuilder removeCharacters(String string, int[] positions) {
        for (int i = 0; i < positions.length; i++) {
            string = string.replace(String.valueOf(positions[i]), "");
        }
        return new StringBuilder(string);
    }

    public static StringBuilder insertCharacters(String string, int[] positions, char[] characters) {
        StringBuilder sb = new StringBuilder(string);
        int z = 0;
        for (int i = 0; i < positions.length; i++) {
            if (string.charAt(positions[i]) != characters[i]) {
                sb = sb.insert(positions[i] + z, characters[i]);
                z++;
            }
        }
        return sb;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

}
