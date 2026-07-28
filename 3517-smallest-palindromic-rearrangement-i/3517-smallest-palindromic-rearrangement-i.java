class Solution {
    public String smallestPalindrome(String s) {
        //T.C : O(n log n)
        //S.C : O(1) (ignoring the space taken for sorting internally)

        int arr_length = s.length();
        int mid = arr_length / 2;
        char[] charsArray = s.toCharArray();
        Arrays.sort(charsArray, 0, mid); //mid is not included

        for (int i = 0; i < mid; i++) {
            charsArray[arr_length - 1 - i] = charsArray[i];
        }

        return new String(charsArray);
    }
}