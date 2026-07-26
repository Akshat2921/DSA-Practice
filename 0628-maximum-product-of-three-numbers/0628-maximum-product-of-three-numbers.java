class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int arr_length=nums.length;
        int a=nums[arr_length-1]*nums[arr_length-2]*nums[arr_length-3];
        int b=nums[0]*nums[1]*nums[arr_length-1];
        return Math.max(a,b);
    }
}