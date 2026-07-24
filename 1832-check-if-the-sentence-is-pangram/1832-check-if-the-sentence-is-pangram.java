class Solution {
    public boolean checkIfPangram(String sentence) {
        if(sentence.length()<26) return false;

        int[] alphabets_frequency_checking=new int[26];
        for(int i=0;i<sentence.length();i++){
            char character=sentence.charAt(i);
            int index=character-'a';
            alphabets_frequency_checking[index]++;
        }

        for(int i=0;i<26;i++){
            if(alphabets_frequency_checking[i]==0) return false;
        }

        return true;
    }
}