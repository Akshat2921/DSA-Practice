class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        List<List<Integer>> answer=new ArrayList<>();
        for(int i=0;i<n-2;i++){
            while(i>0 && i<n-2 && nums[i]==nums[i-1]) i++;
            int left=i+1,right=n-1;
            int target_Sum=-nums[i];
            while(left<right){
                int current_Sum=nums[left]+nums[right];
                if(current_Sum==target_Sum){
                    answer.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                    while(left<right && nums[left]==nums[left-1]) left++;
                    while(left<right && nums[right]==nums[right+1]) right--;
                }else if(current_Sum<target_Sum) left++;
                else right--;
            }
        }
        return answer;
    }
}