class Solution {
    /*
    public int fib(int n) {
        // O(2^n) and sc-> O(N)
         if(n<=1) return n;
        return fib(n-1)+fib(n-2); 

        int[] memo=new int[31];
        return solve(n,memo);
    }
    private int solve(int n,int[] memo){
        if(n<=1) return n;

        if(memo[n]!=0) return memo[n];

        memo[n]=solve(n-1,memo)+solve(n-2,memo);
        return memo[n];
    }
    //O(n) and sc->O(N)
    
    public int fib(int n){
        if(n<=1) return n;

        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;

        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];
    }
    //O(N) && sc->O(N)

    */

    public int fib(int n){
        if(n<=1) return n;

        int prev2=0,prev1=1;

        for(int i=2;i<=n;i++){
            int curr=prev2+prev1;
            prev2=prev1;
            prev1=curr;
        }
        return prev1;

        //O(N) && sc->O(1)
    }
}