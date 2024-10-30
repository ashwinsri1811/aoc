package day1;

import util.Input;
import util.Utility;

import java.io.IOException;
import java.util.List;

public class Solver {

    public static void main(String[] args) {
        try {
            List<String> inputs = Utility.readLine("day1", Input.TEST);
            for (String s: inputs) {
                System.out.println(solvePart2(s));
            }
        } catch (IOException e) {
            System.out.println("Error while reading input file: " + e);
        } catch (Exception e) {
            System.out.println("Error while executing code: " + e);
        }
    }

    public static int solvePart1(String s) {
        int a = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') a++;
            else a--;
        }
        return a;
    }

    public static int solvePart2(String s) {
        int a = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') a++;
            else a--;
            if (a < 0) return i + 1;
        }
        return a;
    }
}
