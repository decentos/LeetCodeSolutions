package easy;

public class E3005CountElementsMaxFreq {

    public int maxFrequencyElements(int[] nums) {
        int[] count = new int[101];
        int maxFreq = 0, totalFreq = 0;

        for (int num : nums) {
            count[num]++;

            if (count[num] > maxFreq) {
                maxFreq = count[num];
                totalFreq = count[num];
            } else if (count[num] == maxFreq) {
                totalFreq += maxFreq;
            }
        }
        return totalFreq;
    }
}
