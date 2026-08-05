class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] inDegree=new int[n];
        boolean[] suspicious=new boolean[n];

        for(int[] edge:invocations){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            inDegree[v]++;
        }

        Queue<Integer> queue=new LinkedList<>();
        queue.offer(k);
        suspicious[k]=true;

        while(!queue.isEmpty()){
            int curr=queue.poll();

            for(int neigh:adj.get(curr)){
                inDegree[neigh]--;
                if(!suspicious[neigh]){
                    queue.offer(neigh);
                    suspicious[neigh]=true;
                }
            }
        }

        List<Integer> result=new ArrayList<>();
        boolean cannotRemove=false;

        for(int i=0;i<n;i++){
            if(suspicious[i] && inDegree[i]>0){
                cannotRemove=true;
                break;
            }
            if(!suspicious[i]){
                result.add(i);
            }
        }
        if(cannotRemove){
            List<Integer> vec=new ArrayList<>();
            for(int i=0;i<n;i++) vec.add(i);
            return vec;
        }
        return result;
    }
}