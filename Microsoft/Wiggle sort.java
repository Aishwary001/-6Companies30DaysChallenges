import java.util.Arrays;

class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int extra[] = Arrays.copyOf(nums, n); // Create a separate copy of nums
        Arrays.sort(extra);
        int j = n - 1;
        int i = 1;
        // Fill odd indices first with larger values
        while (i < n) {
            nums[i] = extra[j];
            i += 2;
            j--;
        }
        i = 0;
        // Fill even indices with remaining smaller values
        while (i < n) {
            nums[i] = extra[j];
            i += 2;
            j--;
        }
    }
}
