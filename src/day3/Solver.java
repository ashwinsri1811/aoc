package day3;

import util.Input;
import util.Utility;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solver {

    public static void main(String[] args) {
        try {
            List<String> inputs = Utility.readLine("day3", Input.TEST);
            for (String s: inputs) {
                System.out.println(solvePart2(s));
            }
        } catch (IOException e) {
            System.out.println("Error while reading input file: " + e);
        } catch (Exception e) {
            System.out.println("Error while executing code: " + e);
        }
    }

    public static Point getNext(Point p, char direction) {
        switch (direction) {
            case '>': return new Point(p.x + 1, p.y);
            case '<': return new Point(p.x - 1, p.y);
            case 'v': return new Point(p.x, p.y + 1);
            case '^': return new Point(p.x, p.y - 1);
        }
        return p;
    }

    public static int solvePart1(String s) {
        Set<Point> visited = new HashSet<>();
        Point curr = new Point(0, 0);
        visited.add(curr);
        for (int i = 0; i < s.length(); i++) {
            curr = getNext(curr, s.charAt(i));
            visited.add(curr);
        }
        return visited.size();
    }

    public static int solvePart2(String s) {
        Set<Point> visited = new HashSet<>();
        Point santa = new Point(0, 0);
        Point roboSanta = new Point(0, 0);
        visited.add(santa);
        visited.add(roboSanta);
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                santa = getNext(santa, s.charAt(i));
                visited.add(santa);
            } else {
                roboSanta = getNext(roboSanta, s.charAt(i));
                visited.add(roboSanta);
            }
        }
        return visited.size();
    }
}
