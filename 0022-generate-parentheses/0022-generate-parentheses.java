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

// class Solution {
//     public List<String> generateParenthesis(int n) {
//         return generate(n, new ArrayList<>(), "");
//     }

//     private List<String> generate(int n, List<String> result, String current_string) {

//         if (current_string.length() == 2 * n) {
//             if (isValid(current_string)) {
//                 result.add(current_string);
//             }
//             return result;
//         }

//         generate(n, result, current_string + '(');
//         generate(n, result, current_string + ')');

//         return result;
//     }

//     private boolean isValid(String generated_parenthesis) {

//         int count = 0;

//         for (int i = 0; i < generated_parenthesis.length(); i++) {

//             if (generated_parenthesis.charAt(i) == '(') {
//                 count++;
//             } 
//             else {
//                 count--;
//             }

//             if (count < 0) return false;
//         }

//         return count == 0;
//     }
// }

// Tumhare code mein har position par 2 choices hain:
// current_string + '('
// current_string + ')'

// Aur total length 2*n honi hai.

// Step 1: Total strings kitni generate hongi?

// Agar length 2n hai aur har position par 2 choices hain:
// 2 × 2 × 2 × ... × 2
//         2n times

//         So: = 2^(2n)

//         Ab exponent rule:2^(2n) = (2²)^n = 4^n

//         Step 2: Har string ko check karne mein kitna time?

// Tumhara isValid():for(int i = 0; i < generated_parenthesis.length(); i++)
// String ki length: 2n

// O(n)

// = O(4^n × n)

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(n, result, "", 0, 0);
        return result;
    }
    private void generate(int n,List<String> result,String current_string,int open,int close){
        if(current_string.length()==2*n){
            result.add(current_string);
            return;
        }
        if(open<n){
            generate(n,result,current_string+"(",open+1,close);
        }
        if(close<open){
            generate(n,result,current_string+')',open,close+1);
        }
    }
}

//TC

// Pehle hum 2^(2n) = 4^n saare possible strings bana rahe the.

// Ab hum invalid branches ko prune kar rahe hain.

// Valid Parentheses ki actual number hoti hai Catalan number:

// Cₙ = 1/(n+1) × (2n choose n)
// Cₙ = (2n)! / ((n + 1)! × n!)

// Cₙ = n pairs of parentheses ki valid combinations ki total number.

// Aur iska asymptotic growth approximately:
// Aur iska asymptotic growth approximately:

// Har valid string ki length 2n hai, aur string construction/copying ki wajah se O(n) factor consider karna padta hai.

// So commonly is solution ki:

// TC = O(Cₙ × n)

// ya approximately:

// O(4^n / √n)

// SC

// Recursion ki maximum depth:

// 2n

// So recursion stack:

// O(n)    Result mein Cₙ strings store hongi, each of length 2n:

// Output space = O(Cₙ × n)

// Result mein Cₙ strings store hongi, each of length 2n:

// Output space = O(Cₙ × n)

// Interview mein short answer:

// Time: O(Cₙ × n)
// Auxiliary Space: O(n)
// Output Space: O(Cₙ × n)