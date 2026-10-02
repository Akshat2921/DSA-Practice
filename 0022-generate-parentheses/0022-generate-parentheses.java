// 1. Stack Approach

// For every generated string, isValid() mein 2n characters traverse hote hain.

// Time Complexity: O(2^(2n) × n) = O(4ⁿ × n)
// Space Complexity: O(n) for Stack + O(n) recursion depth
// So SC = O(n) auxiliary space (output ko exclude karke).

// class Solution {
//     public List<String> generateParenthesis(int n) {
//       return generate(n,new ArrayList<>(),"");
//     }
//     private List<String> generate(int n,List<String> result,String current_string){
//         if(current_string.length()==2*n){
//             if(isValid(current_string)){
//                 result.add(current_string);
//             }
//             return result;
//         }
//         generate(n,result,current_string+'(');
//         generate(n,result,current_string+')');

//         return result;
//     }
//     private boolean isValid(String generated_parenthesis){
//         Stack<Character> st = new Stack<>();

//         for (int i = 0; i < generated_parenthesis.length(); i++) {

//             char ch = generated_parenthesis.charAt(i);

//             if (ch == '(') {
//                 st.push(ch);
//             } 
//             else {
//                 if (st.isEmpty()) return false;
//                 st.pop();
//             }
//         }

//         return st.isEmpty();

//   
//     }
// }

// 2. Count Approach

// Count method bhi har generated string ke 2n characters traverse karta hai.

// Time Complexity: O(2^(2n) × n) = O(4ⁿ × n)
// Space Complexity: O(n) recursion depth
// count khud sirf O(1) hai.

class Solution {
    public List<String> generateParenthesis(int n) {
        return generate(n, new ArrayList<>(), "");
    }

    private List<String> generate(int n, List<String> result, String current_string) {

        if (current_string.length() == 2 * n) {
            if (isValid(current_string)) {
                result.add(current_string);
            }
            return result;
        }

        generate(n, result, current_string + '(');
        generate(n, result, current_string + ')');

        return result;
    }

    private boolean isValid(String generated_parenthesis) {

        int count = 0;

        for (int i = 0; i < generated_parenthesis.length(); i++) {

            if (generated_parenthesis.charAt(i) == '(') {
                count++;
            } 
            else {
                count--;
            }

            if (count < 0) return false;
        }

        return count == 0;
    }
}