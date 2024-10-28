package uber;

public class M974SubarrayDivisibleK {

    public int subarraysDivByK(int[] nums, int k) {
        int[] modCount = new int[k];
        modCount[0] = 1;
        int prefixMod = 0, count = 0;

        for (int num : nums) {
            prefixMod = (prefixMod + num) % k;
            if (prefixMod < 0) {
                prefixMod += k;
            }
            count += modCount[prefixMod];
            modCount[prefixMod]++;
        }
        return count;
    }
}
