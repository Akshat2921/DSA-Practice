class Solution {
    public String smallestSubsequence(String s) {
         //TC = O(n)  &&  SC = O(1)
        boolean[] occurred=new boolean[26];   // O(26) space = O(1)
        int[] storing_index=new int[26];     // O(26) space = O(1)

        for(int i=0;i<s.length();i++){   //O(N)
            char ch=s.charAt(i);
            int index=ch-'a';
            storing_index[index]=i;
        }
        StringBuilder sb=new StringBuilder();   //O(1)

        for(int i=0;i<s.length();i++){    //O(N)
            char ch=s.charAt(i);
            int index=ch-'a';

            if(occurred[index]) continue;

            if(sb.length()==0) {
                sb.append(ch);
                occurred[index]=true;
            }
            else {
                int idx=sb.length()-1;
                //Total pushes ≤ n && Total pops ≤ total pushes
                while(idx>=0 && 
                            sb.charAt(idx)-ch>0 
                            && storing_index[sb.charAt(idx)-'a']>i){
                    
                    occurred[sb.charAt(idx)-'a']=false;
                    sb.deleteCharAt(idx);
                    idx--;
                }
                sb.append(ch);
                occurred[index]=true;
            }
            }
        return sb.toString();        //O(N)
    }
}