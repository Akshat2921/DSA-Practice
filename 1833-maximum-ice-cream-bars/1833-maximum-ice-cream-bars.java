class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int sum=0;
        for(int a:costs){
            if(coins<a) break;
            sum++;
            coins-=a;
        }
        return sum;
    }
}