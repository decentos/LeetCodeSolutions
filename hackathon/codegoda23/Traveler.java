package codegoda23;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Traveler {
    private static List<List<Integer>> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cities = sc.nextInt();
        int flights = sc.nextInt();
        list = new ArrayList<>(cities);
        for (int i = 0; i < cities; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < flights; i++) {
            int curr = sc.nextInt() - 1;
            int connect = sc.nextInt() - 1;
            list.get(curr).add(connect);
        }
        int queries = sc.nextInt();
        for (int i = 0; i < queries; i++) {
            int start = sc.nextInt() - 1;
            int count = dfs(start, new boolean[cities]);
            System.out.println(count);
        }
        sc.close();
    }

    private static int dfs(int city, boolean[] visited) {
        visited[city] = true;
        int count = 1;
        for (int next : list.get(city)) {
            if (!visited[next]) {
                count += dfs(next, visited);
            }
        }
        return count;
    }
}
