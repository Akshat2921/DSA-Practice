class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        /*
        Complexity Analysis
        Time Complexity: O(bank.length × 8 × 4)
        Worst case mein har bank string ko explore karna pad sakta hai (BFS queue mein)
        Har gene string ke liye 8 positions try karte hain, har position pe 4 characters
        Chhoti si complexity hai kyunki bank.length ≤ 10 (bahut chhota constraint)
        Space Complexity: O(bank.length)
        
        bankSet, visited set, aur queue sab max bank.length size tak ja sakte hain
        
        Kyun BFS aur DFS nahi?
        DFS bhi kaam kar sakta tha (path dhoondne ke liye), lekin DFS guarantee nahi deta minimum steps ka — wo ek path dhoondh lega but shortest nahi ho sakta. BFS level-order explore karta hai, isliye jaise hi target pehli baar milta hai, wahi guaranteed shortest distance hoti hai. Isliye "minimum steps" wale problems mein hamesha BFS use karo.
         */
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));

        if (!bankSet.contains(endGene))
            return -1;

        char[] chars = { 'A', 'C', 'G', 'T' };

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(startGene);
        visited.add(startGene);

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                if (current.equals(endGene)) {
                    return steps;
                }

                char[] currArr = current.toCharArray();
                for (int pos = 0; pos < currArr.length; pos++) {
                    char original = currArr[pos];

                    for (char c : chars) {
                        if (c == original)
                            continue;

                        currArr[pos] = c;

                        String mutated = new String(currArr);

                        if (bankSet.contains(mutated) && !visited.contains(mutated)) {
                            visited.add(mutated);
                            queue.offer(mutated);
                        }
                    }
                    currArr[pos] = original;
                }
            }
            steps++;
        }
        return -1;
    }
}