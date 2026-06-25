class Solution {

    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==target) nums[i]=1;
            else nums[i]=-1;
        }
        for(int i=1;i<n;i++){
            nums[i]+=nums[i-1];
        }
        long ans=0;
        for(int l=0;l<n;l++){
            for(int r=l;r<n;r++){
                int sum=nums[r]-((l>0)?nums[l-1]:0);
                if(sum>0) ans++;
            }
        }
        return (int) ans;
    }
}