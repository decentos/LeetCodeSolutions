package string;

public class M165CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {
        String[] subs1 = version1.split("\\.");
        String[] subs2 = version2.split("\\.");
        int n1 = subs1.length, n2 = subs2.length;

        for (int i = 0; i < Math.max(subs1.length, subs2.length); i++) {
            int sub1 = i < n1 ? Integer.parseInt(subs1[i]) : 0;
            int sub2 = i < n2 ? Integer.parseInt(subs2[i]) : 0;

            if (sub1 > sub2) {
                return 1;
            } else if (sub1 < sub2) {
                return -1;
            }
        }
        return 0;
    }
}
