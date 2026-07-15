class Solution {
    public int gcdOfOddEvenSums(int n) {
        /* since sum of odd is summation of 1+3+5+7+...... 
        which can be noted as its general last term is 2k-1 where k starts from 1 now 
        summation of 2k-1 where k is from 1 to n so 
        2*(1+2+3+4+.......n) - (1+2+3+4.....n) = 2*(n*(n+1)/2) -n 
        => n*(n+1) -n => n^2 + n - n => n^2
        */ 
        // int sumOdds=n*n;
        
        /* since sum of even is summation of 2+4+6+8+...... 
        which can be noted as its general last term is 2k where k starts from 1 now 
        summation of 2k where k is from 1 to n so 
        2*(1+2+3+4+.......n) = 2*(n*(n+1)/2) 
        => n*(n+1)
        */

       // int sumEven=n*(n+1);

        /*NOW gcd of {n*n , n*(n+1)} would be 
        n * gcd of {n,n+1} and since gcd of n.n+1 would always be 1 only as 1,2=>1 | 4,5 =>1 etc.... 
        so at the end it would be n* gcd(n,n+1) 
        => n* 1 => n 
        so simple we have to return n only 
        */

        return n;
    }
}