package day5;

import util.Input;
import util.Utility;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solver {

    private static final String vowels = "aeiou";
    private static final List<String> prohibited = Arrays.asList("ab", "cd", "pq", "xy");

    public static void main(String[] args) {
        try {
            List<String> inputs = Utility.readLine("day5", Input.TEST);
            int res = 0;
            for (String s: inputs) {
                res += solvePart2(s);
            }
            System.out.println(res);
        } catch (IOException e) {
            System.out.println("Error while reading input file: " + e);
        } catch (Exception e) {
            System.out.println("Error while executing code: " + e);
        }
    }

    private static boolean isValidFirstCase(String s) {
        int count = 0;
        boolean hasAtleast3Vowels = false;
        boolean hasSameConsecutiveLetters = false;
        boolean hasProhibitedSequence = false;
        for (int i = 0; i < s.length(); i++) {
            /* First Condition */
            if (vowels.indexOf(s.charAt(i)) >= 0)
                count++;
            if (count == 3) hasAtleast3Vowels = true;

            /* Second + Third Condition */
            if (i < s.length() - 1) {
                if (s.charAt(i) == s.charAt(i + 1)) hasSameConsecutiveLetters = true;
                if (prohibited.contains(s.substring(i, i + 2))) hasProhibitedSequence = true;
            }

            if (hasProhibitedSequence) return false;
        }
        return hasAtleast3Vowels && hasSameConsecutiveLetters;
    }

    private static boolean isValidSecondCase(String s) {
        Set<String> twoLetterWords = new HashSet<>();
        boolean satisfiesFirstCondition = false;
        boolean satisfiesSecondCondition = false;
        int indexOfLastWordInserted = -1;
        for (int i = 0; i < s.length(); i++) {
            /* Second Condition */
            if (i > 0 && i < s.length() - 1) {
                if (s.charAt(i - 1) == s.charAt(i + 1)) {
                    satisfiesSecondCondition = true;
                }
            }

            /* First Condition */
            if (!satisfiesFirstCondition && i < s.length() - 1) {
                String word = s.substring(i, i + 2);
                if (i == 0) {
                    twoLetterWords.add(word);
                    indexOfLastWordInserted = 1;
                } else {
                    if (s.charAt(i + 1) == s.charAt(i - 1) && s.charAt(i) == s.charAt(i - 1) && indexOfLastWordInserted >= i) continue;
                    else if (twoLetterWords.contains(word)) {
                        satisfiesFirstCondition = true;
                    }
                    else {
                        twoLetterWords.add(word);
                        indexOfLastWordInserted = i + 1;
                    }
                }
            }
        }
        return satisfiesFirstCondition && satisfiesSecondCondition;
    }

    public static int solvePart1(String s) {
        return isValidFirstCase(s) ? 1 : 0;
    }

    public static int solvePart2(String s) {
        return isValidSecondCase(s) ? 1 : 0;
    }
}
