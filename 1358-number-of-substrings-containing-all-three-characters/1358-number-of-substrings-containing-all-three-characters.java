class Solution {
    public int numberOfSubstrings(String s) {
        int length=s.length();
        int[] freq=new int[3];

        int left=0,right=0;  
        int result=0;
        while(right<length){
            char ch=s.charAt(right);
            freq[ch-'a']++;

            while(freq[0]>0 && freq[1]>0 && freq[2]>0){
                result+=(length-right);
                freq[s.charAt(left)-'a']--;
                left++;
            }
            right++;
        }
        return result;
    }
}