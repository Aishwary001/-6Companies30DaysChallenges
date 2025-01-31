class Solution {
    public int minMoves2(int[] nums) {
       Arrays.sort(nums);
       int mid = nums.length/2;
       int median = nums.length % 2 == 0 ? (nums[mid] + nums[mid-1])/2 : nums[mid];

       int steps = 0;
       for(int num : nums){
          steps += Math.abs(median - num);
       }

       return steps;
    }
}
