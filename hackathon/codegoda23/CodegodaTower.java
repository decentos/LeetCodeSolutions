package codegoda23;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodegodaTower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] bossPower = new int[n];
        int[] soldierPower = new int[n];
        for (int i = 0; i < n; i++) {
            bossPower[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            soldierPower[i] = sc.nextInt();
        }
        sc.close();

        List<Integer> soldiers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int boss = bossPower[i];
            int soldier = soldierPower[i];
            while (soldiers.size() > 0 && boss > soldiers.get(0)) soldiers.remove(0);
            if (soldier >= boss) soldiers.add(soldier);
        }
        System.out.println(soldiers.size());
    }
}
