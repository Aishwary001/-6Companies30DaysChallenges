import java.util.*;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // Step 1: Sort the envelopes
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1]; // Sort heights in descending order for same width
            }
            return a[0] - b[0]; // Sort widths in ascending order
        });

        // Step 2: Extract heights and apply LIS
        int[] heights = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            heights[i] = envelopes[i][1];
        }

        // Step 3: Find the LIS of heights
        return lengthOfLIS(heights);
    }

    private int lengthOfLIS(int[] nums) {
        List<Integer> lis = new ArrayList<>();
        for (int num : nums) {
            int index = Collections.binarySearch(lis, num);
            if (index < 0) {
                index = -(index + 1);
            }
            if (index == lis.size()) {
                lis.add(num);
            } else {
                lis.set(index, num);
            }
        }
        return lis.size();
    }
}
