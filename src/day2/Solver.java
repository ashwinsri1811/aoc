package day2;

import util.Input;
import util.Utility;

import java.io.IOException;
import java.util.List;

public class Solver {

    class Cuboid {
        public int length;
        public int breadth;
        public int height;

        Cuboid() {
        }

        Cuboid(int l, int b, int h) {
            this.length = l;
            this.breadth = b;
            this.height = h;
        }

        public int getSurfaceArea() {
            return 2 * (this.length * this.breadth + this.breadth * this.height + this.length * this.height);
        }

        public int getSmallestSurface() {
            return Math.min(this.length * this.breadth, Math.min(this.breadth * this.height, this.length * this.height));
        }

        public int getVolume() {
            return this.length * this.breadth * this.height;
        }

        public int getSmallestPerimeter() {
            return 2 * Math.min(this.length + this.breadth, Math.min(this.breadth + this.height, this.length + this.height));
        }

    }

    public static void main(String[] args) {
        try {
            List<String> inputs = Utility.readLine("day2", Input.TEST);
            long res = 0L;
            for (String s : inputs) {
                int ans = solvePart2(s);
                System.out.println(ans);
                res += ans;
            }
            System.out.println("Final: " + res);
        } catch (IOException e) {
            System.out.println("Error while reading input file: " + e);
        } catch (Exception e) {
            System.out.println("Error while executing code: " + e);
        }
    }

    public Cuboid getCuboid(String s) {
        int firstX = s.indexOf('x');
        int lastX = s.lastIndexOf('x');
        return new Cuboid(
                Integer.parseInt(s.substring(0, firstX)),
                Integer.parseInt(s.substring(firstX + 1, lastX)),
                Integer.parseInt(s.substring(lastX + 1))
        );
    }

    public static int solvePart1(String s) {
        Cuboid c = new Solver().getCuboid(s);
        return c.getSurfaceArea() + c.getSmallestSurface();
    }

    public static int solvePart2(String s) {
        Cuboid c = new Solver().getCuboid(s);
        return c.getVolume() + c.getSmallestPerimeter();
    }
}
