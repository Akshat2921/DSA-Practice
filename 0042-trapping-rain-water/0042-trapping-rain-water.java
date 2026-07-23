class Solution {
    public int trap(int[] height) {
        int left=0,right=height.length-1;
        int left_Max=0,right_Max=0;
        int total_water_trapped=0;
        while(left<right){
            if(height[left]>left_Max) left_Max=height[left];
            if(height[right]>right_Max) right_Max=height[right];
            if(left_Max<right_Max){
                total_water_trapped+=left_Max-height[left];
                left++;
            }
            else{
                total_water_trapped+=right_Max-height[right];
                right--;
            }
        }
        return total_water_trapped;
    }
}