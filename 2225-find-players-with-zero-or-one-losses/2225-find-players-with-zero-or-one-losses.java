class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer,Integer> lost_Matches_Count=new HashMap<>();

        for(int[] match:matches){
            int lost_member=match[1];
            int won_member=match[0];

            lost_Matches_Count.putIfAbsent(won_member,0);

            lost_Matches_Count.put(lost_member,lost_Matches_Count.getOrDefault(lost_member,0)+1);
        }

        List<Integer> always_won=new ArrayList<>();
        List<Integer> lost_Only_Once=new ArrayList<>();

        for(Map.Entry<Integer,Integer> entry:lost_Matches_Count.entrySet()){
            if(entry.getValue()==0){
                always_won.add(entry.getKey());
            }
            else if(entry.getValue()==1){
                lost_Only_Once.add(entry.getKey());
            }
        }
        Collections.sort(always_won); 
        Collections.sort(lost_Only_Once); 

        List<List<Integer>> result=new ArrayList<>();
        result.add(always_won);
        result.add(lost_Only_Once);

        return result;
    }
}