class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb=new StringBuilder();
        for(String word:words){
            int sum=0;

            for(int i=0;i<word.length();i++){
                sum+=weights[word.charAt(i)-'a'];
            }
            sb.append((char)('z'-(sum%26)));
        }
        return sb.toString();
    }
}