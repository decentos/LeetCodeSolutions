package codegoda23;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PrimeProperties {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        sc.close();

        List<Integer> path;
        if (x < y) {
            path = findPath(x, y);
        } else {
            path = findPath(y, x);
            if (path != null) Collections.reverse(path);
        }
        printPath(path);
    }

    private static List<Integer> findPath(int x, int y) {
        List<Integer> path = new ArrayList<>();
        path.add(x);
        while (x != y) {
            int nextPrime = findNextPrime(x, y);
            if (nextPrime == -1) return null;
            path.add(nextPrime);
            x = nextPrime;
        }
        return path;
    }

    private static int findNextPrime(int x, int y) {
        for (int i = x + 1; i <= y; i++) {
            if (isPrime(i) && isPrime(i - x)) return i;
        }
        return -1;
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private static void printPath(List<Integer> path) {
        if (path == null) {
            System.out.println("Sorry Ms. Agoji!");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i : path) sb.append(i).append(" ");
            System.out.println(sb.substring(0, sb.length() - 1));
        }
    }
}
