class Solution {
    public int smallestNumber(int n, int t) {
        while(!isDivisble(n,t)){
            n++;
        }
        return n;
    }
    private boolean isDivisble(int number,int t){
        int product=1;

        while(number>0){
            product *= number%10;
            number/=10;
        }

        return product%t==0;
    }
}