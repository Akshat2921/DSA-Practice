class Solution {
    public List<String> generateParenthesis(int n) {
      return generate(n,new ArrayList<>(),"");
    }
    private List<String> generate(int n,List<String> result,String current_string){
        if(current_string.length()==2*n){
            if(isValid(current_string)){
                result.add(current_string);
            }
            return result;
        }
        generate(n,result,current_string+'(');
        generate(n,result,current_string+')');

        return result;
    }
    private boolean isValid(String generated_parenthesis){
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < generated_parenthesis.length(); i++) {

            char ch = generated_parenthesis.charAt(i);

            if (ch == '(') {
                st.push(ch);
            } 
            else {
                if (st.isEmpty()) return false;
                st.pop();
            }
        }

        return st.isEmpty();

        // int count=0;
        // for(int i=0;i<generated_parenthesis.length();i++){
        //     if(generated_parenthesis.charAt(i)=='(') count++;
        //     else count--;
        // }
        // return count==0;
        // //this will reduce O(n) to O(1)
    }
}