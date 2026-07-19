class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);  //O(N logN)
        int left=0,right=tokens.length-1;

        int score=0,max_score=0;
        while(left<=right){   //O(N)
            if(score>0 && power<tokens[left]){
                max_score=Math.max(max_score,score);
                score-=1;
                power+=tokens[right];
                right--;
            }
            else if(power>=tokens[left]){
                score+=1;
                power-=tokens[left];
                left++;
            }
            else break;
        }
        return Math.max(max_score,score); 
    }
}