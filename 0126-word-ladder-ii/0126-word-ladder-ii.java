import java.util.*;

class Solution {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        if (!set.contains(endWord)) return res;

        // word -> list of parent words that lead to it
        Map<String, List<String>> parents = new HashMap<>();
        
        // BFS level by level
        Set<String> currentLevel = new HashSet<>();
        currentLevel.add(beginWord);
        set.remove(beginWord);
        boolean found = false;

        while (!currentLevel.isEmpty() && !found) {
            Set<String> nextLevel = new HashSet<>();
            // remove current level from set to avoid revisiting
            for (String word : currentLevel) set.remove(word);

            for (String word : currentLevel) {
                char[] arr = word.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char orig = arr[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == orig) continue;
                        arr[i] = ch;
                        String newWord = new String(arr);
                        if (set.contains(newWord) || nextLevel.contains(newWord)) {
                            nextLevel.add(newWord);
                            parents.computeIfAbsent(newWord, k -> new ArrayList<>()).add(word);
                            if (newWord.equals(endWord)) found = true;
                        }
                    }
                    arr[i] = orig;
                }
            }
            currentLevel = nextLevel;
        }

        if (!found) return res;

        // DFS to reconstruct paths
        LinkedList<String> path = new LinkedList<>();
        path.addFirst(endWord);
        dfs(beginWord, endWord, parents, path, res);
        return res;
    }

    private void dfs(String beginWord, String word, Map<String, List<String>> parents,
                     LinkedList<String> path, List<List<String>> res) {
        if (word.equals(beginWord)) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (!parents.containsKey(word)) return;
        for (String parent : parents.get(word)) {
            path.addFirst(parent);
            dfs(beginWord, parent, parents, path, res);
            path.removeFirst();
        }
    }

    public List<List<String>> findSequences(String startWord, String targetWord, String[] wordList) {
        return findLadders(startWord, targetWord, Arrays.asList(wordList));
    }
}