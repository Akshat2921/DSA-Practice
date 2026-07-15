class Solution {
    public int minFlips(int a, int b, int c) {
        int flips_required=0;

        while(a>0 || b>0 || c>0){

            if((c&1)==1){
                if((a&1)==0 && (b&1)==0){
                    flips_required++;
                }
            }else{
                flips_required+=(a&1)+(b&1);
            }

            a>>=1;
            b>>=1;
            c>>=1;
        }
        return flips_required;
    }
}