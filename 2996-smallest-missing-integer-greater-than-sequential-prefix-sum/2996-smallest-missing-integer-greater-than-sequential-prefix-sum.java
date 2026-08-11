class Solution {
    public int missingInteger(int[] nums) {
        int n=nums.length;

        int sum=nums[0];
        int i=0;
        while(i+1<n && nums[i+1]==nums[i]+1){
            i++;
            sum+=nums[i];
        }
        Set<Integer> present=new HashSet<>();
        for(int num:nums) present.add(num);

        int x=sum;
        while(present.contains(x)){
            x++;
        }
        return x;
    }
}