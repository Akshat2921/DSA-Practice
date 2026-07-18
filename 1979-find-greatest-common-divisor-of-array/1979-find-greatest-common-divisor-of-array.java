class Solution {
    public int findGCD(int[] nums) {
       int mx = Integer.MIN_VALUE;
        int mn = Integer.MAX_VALUE;
        for (int num : nums) {
            mn = Math.min(mn, num);
            mx = Math.max(mx, num);
        }
        return gcd(mx, mn); 
    }
    private int gcd(int a,int b){
        if(b==0) return a;

        return gcd(b,a%b);
    }
    /*
    Time min/max -> O(n) && space -> O(1)
    GCD (Euclidean) -> O(log(min(mx,mn))) and sc-> O(log(min(mx,mn))) recursion stack 
    Time complexity: O(n+logM).
    */
}