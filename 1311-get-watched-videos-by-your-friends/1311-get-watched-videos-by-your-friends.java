class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Queue<Integer> queue=new LinkedList<>();
        HashSet<Integer> visited=new HashSet<>();
        queue.offer(id);
        visited.add(id);
        int currLevel=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            //iterate it level by level
            for(int i=0;i<size;i++){
                int curId=queue.poll();
                for(int friend:friends[curId]){
                    if(!visited.contains(friend)){
                        visited.add(friend);
                        queue.offer(friend);
                    }
                }
            }
            currLevel++;
            if(currLevel == level) break;
        }
        HashMap<String,Integer> freqMap=new HashMap<>();
        while(!queue.isEmpty()){
            int curId=queue.poll();
            for(String video:watchedVideos.get(curId)){
                freqMap.put(video,freqMap.getOrDefault(video,0)+1);
            }
        }
            List<String> result=new ArrayList<>(freqMap.keySet());

            result.sort((a,b) -> {
                if(!freqMap.get(a).equals(freqMap.get(b))){
                    return freqMap.get(a)-freqMap.get(b);
                }
                return a.compareTo(b);
            });
        return result;
    }
}