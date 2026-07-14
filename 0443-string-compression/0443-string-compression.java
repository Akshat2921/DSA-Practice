class Solution {
    public int compress(char[] chars) {
        int update_index=0;
        int i=0;

        while(i<chars.length){
            char previous_character=chars[i];
            int previous_character_index=i;

            while(i<chars.length && chars[i]==previous_character){
                i++;
            }
            int count=i-previous_character_index;

            chars[update_index]=previous_character;
            update_index++;

            if(count>1){
                for(char digitChar:String.valueOf(count).toCharArray()){
                    chars[update_index]=digitChar;
                    update_index++;
                }
            }
        }
        return update_index;
    }
}