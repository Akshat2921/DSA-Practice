class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        // int closest_Sum=Integer.MAX_VALUE; //Math.abs(24 - (-1)) < Math.abs(2147483647 - (-1))
    //  => Math.abs(25) < Math.abs(2147483647 + 1)\
    //2147483647 + 1 — ye int ki range se bahar chala jaata hai! Java mein int ka max value 2147483647 hai. Isse aage jaate hi ye overflow

    //Overflow kab hota hai?

// Overflow tabhi hota hai jab closest_Sum - target calculate karte waqt result int ki range (-2147483648 to 2147483647) se bahar chala jaaye.

//and since target ka range diya hai -1000 so as 
//closest_Sum - target = MAX_VALUE - (-1000) = MAX_VALUE + 1000  → OVERFLOW
//matlab overflow 1000 se ho rha hai so shuru mein hi itti value kam se rkho so 

        int closest_Sum = Integer.MAX_VALUE - 10000;
         // isse kya hoga agr kabhi -1000 aaya target mein toh according to formula 
         //closest_sum-target=Integer.MAX_VALUE - 10000 -(-1000) => Integer.MAX_VALUE so ab koi overflow nahi 
         
        int nums_length=nums.length;
        for(int i=0;i<nums_length-2;i++){
            int left=i+1;
            int right=nums_length-1;
            while(left<right){
                int current_Sum=nums[i]+nums[left]+nums[right];
                if(current_Sum==target) return target;

                if(Math.abs(current_Sum-target)<Math.abs(closest_Sum-target)){
                    closest_Sum=current_Sum;
                }

                if(current_Sum<target) left++;
                else right--;
            }
        }
        return closest_Sum;
    }
}