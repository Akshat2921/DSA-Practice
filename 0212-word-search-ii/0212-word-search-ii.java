class Solution {

    //Total Time Complexity -> findWords = buildTrie + (m*n cells × DFS per cell)
     //     = O(N) + O(m * n * 4^L)
     //     = O(N + m·n·4^L)

     //sc -> O(N + L) ≈ O(N) since Trie dominate karta hai (L usually N se chhota hota hai).

    class TrieNode{
        TrieNode[] children=new TrieNode[26];
        boolean isEndOfWord=false;
    }
    //Outer double loop: m * n baar dfs call hoti hai (har cell se ek DFS start hota hai).
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result=new ArrayList<>();
        TrieNode root=buildTrie(words);

        int rows=board.length,cols=board[0].length;

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                dfs(board,r,c,root,new StringBuilder(),result);
            }
        }
        return result;
    }
    //TC -> Har word ki length L_i hoti hai, saare words pe loop karte hain → O(Σ L_i) = O(N) jahan N = total characters across all words (sum of all word lengths).

    // SC -> Worst case mein har character ka naya TrieNode banega (koi shared prefix na ho) → O(N × 26) ≈ O(N)

    private TrieNode buildTrie(String[] words){
        TrieNode root=new TrieNode();   // O(1) time, O(26) space (children array)
        for(String w:words){    // W baar chalega, W = words.length
            TrieNode node=root;
            for(char ch:w.toCharArray()){
                int idx=ch-'a';
                if(node.children[idx]==null){
                    node.children[idx]=new TrieNode();
                }
                node=node.children[idx];
            }
            node.isEndOfWord=true;
        }
        return root;
    }
    //Ek single starting cell se DFS chalne par, worst case mein har step pe 4 directions explore hoti hain, aur depth max word length L tak jaati hai (kyunki Trie mein path se aage nahi jaate agar match na ho — pruning ki wajah se).

    //Toh ek starting cell ka contribution: O(4^L) in the absolute worst case (jab pruning kuch bhi na kaate — practically Trie pruning ki wajah se yeh bahut kam hota hai, but upper bound yehi hai).
    private void dfs(char[][] board,int r,int c,TrieNode node,StringBuilder sb,List<String> result){
        if(r<0 || r>=board.length || c<0 || c>=board[0].length) return;

        char ch=board[r][c];

        // agar yeh node ek complete word ka end hai
        if(ch=='$' || node.children[ch-'a']==null) return;

        TrieNode next=node.children[ch-'a'];
        sb.append(ch);

        if(next.isEndOfWord){
            result.add(sb.toString());
            next.isEndOfWord=false; // duplicate add hone se roko
        }

        //Mark board visited
        board[r][c]='$';

        int[] dr={1,-1,0,0};
        int[] dc={0,0,1,-1};

        for(int d=0;d<4;d++){
            dfs(board,r+dr[d],c+dc[d],next,sb,result);
        }

        // Backtrack: cell aur string dono restore karo
        board[r][c] = ch;
        sb.deleteCharAt(sb.length() - 1);
    }
}