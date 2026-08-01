class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length;
        return calculate_score(nums,0,n-1,true)>=0;
    }
    private int calculate_score(int[] nums,int left,int right,boolean p1Turns){
        if(left>right) return 0;

        if(p1Turns){
            int take_left=nums[left]+calculate_score(nums,left+1,right,false);
            int take_right=nums[right]+calculate_score(nums,left,right-1,false);

            return Math.max(take_left, take_right);
        }
        else{
            int take_left=-nums[left]+calculate_score(nums,left+1,right,true);
            int take_right=-nums[right]+calculate_score(nums,left,right-1,true);

            return Math.min(take_left, take_right);
        }
    }
}