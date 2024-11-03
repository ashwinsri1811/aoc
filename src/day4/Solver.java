package day4;

import util.Input;
import util.Utility;

import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class Solver {

    public static void main(String[] args) {
        try {
            List<String> inputs = Utility.readLine("day4", Input.TEST);
            for (String s: inputs) {
                System.out.println(solvePart2(s));
            }
        } catch (IOException e) {
            System.out.println("Error while reading input file: " + e);
        } catch (Exception e) {
            System.out.println("Error while executing code: " + e);
        }
    }

    public static boolean isValid(String s, int numChars) {
        for(int i = 0 ; i < numChars; i++) {
            if (s.charAt(i) != '0') return false;
        }
        return true;
    }

    public static int solvePart1(String s) {
        int a = 1;
        while (true) {
            StringBuilder res = new StringBuilder(s + a);
            try {
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                md5.update(res.toString().getBytes());
                byte[] digest = md5.digest();
                String myHash = DatatypeConverter
                        .printHexBinary(digest).toUpperCase();
                if (isValid(myHash, 5)) return a;
                a++;
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static int solvePart2(String s) {
        int a = 1;
        while (true) {
            StringBuilder res = new StringBuilder(s + a);
            try {
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                md5.update(res.toString().getBytes());
                byte[] digest = md5.digest();
                String myHash = DatatypeConverter
                        .printHexBinary(digest).toUpperCase();
                if (isValid(myHash, 6)) return a;
                a++;
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
