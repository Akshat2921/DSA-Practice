class Solution {
    public int strStr(String haystack, String needle) {
        char pattern[]=needle.toCharArray();
        int[] lps=buildLPS(pattern);

        int i=0;
        int j=0;
        int n=haystack.length();
        int m=needle.length();

        while(i<n){
            if(needle.charAt(j)==haystack.charAt(i)){
                i++;
                j++;
                if(j==m){
                    return i-m;
                }
            }
            else {
                if(j==0) i++;
                else j=lps[j-1];
            }
        }
        return -1;
    }
    private int[] buildLPS(char pattern[]){
        int len=0;
        int i=1;
        int m=pattern.length;
        int[] lps=new int[m];

        while(i<m){
            if(pattern[len]==pattern[i]){
                len++;
                lps[i]=len;
                i++;
            }else{
                if(len==0) i++;
                else len=lps[len-1];
            }
        }
        return lps;
    }
}