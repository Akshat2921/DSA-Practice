class Solution {
    public void reverse(int[] nums,int i,int j)
    {
       j--;
       while(i<j)
       {
         int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
       }
    }
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        reverse(nums,0,nums.length);
        reverse(nums,0,k);
        reverse(nums,k,nums.length);
    }
}