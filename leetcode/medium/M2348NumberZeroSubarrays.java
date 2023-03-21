package medium;

public class M2348NumberZeroSubarrays {

    public long zeroFilledSubarray(int[] nums) {
        long count = 0, currSeq = 0;
        for (int num : nums) {
            if (num == 0) {
                currSeq++;
            } else if (currSeq > 0) {
                count += currSeq * (currSeq + 1) / 2;
                currSeq = 0;
            }
        }
        if (currSeq > 0) {
            count += currSeq * (currSeq + 1) / 2;
        }
        return count;
    }

    public long zeroFilledSubarray2(int[] nums) {
        long count = 0, currSeq = 0;
        for (int num : nums) {
            if (num == 0) {
                currSeq++;
            } else {
                currSeq = 0;
            }
            count += currSeq;
        }
        return count;
    }
}
