class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String,Double>> graph=new HashMap<>();

        //Build the graph
        for(int i=0;i<equations.size();i++){
            List<String> equation=equations.get(i);
            String dividend=equation.get(0),divisor=equation.get(1);
            double quotient=values[i];

            if(!graph.containsKey(dividend)) graph.put(dividend, new HashMap<String,Double>());
            if(!graph.containsKey(divisor)) graph.put(divisor,new HashMap<String,Double>());

            graph.get(dividend).put(divisor,quotient);
            graph.get(divisor).put(dividend,1/quotient);
        }

        double[] result=new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            List<String> query=queries.get(i);
            String dividend=query.get(0);
            String divisor=query.get(1);

            if(!graph.containsKey(dividend) || !graph.containsKey(divisor)) 
            result[i]=-1.00;
            else if(dividend.equals(divisor)) result[i]=1.00;
            else{
                HashSet<String> visited=new HashSet<>();
                result[i]=backtrackEvaluate(graph,dividend,divisor,1,visited);
            }
        }
        return result;
    }
    private double backtrackEvaluate(HashMap<String,HashMap<String,Double>> graph,String curNode,String targetNode,double product,Set<String> visited){
        visited.add(curNode);
        double ret=-1.0;

        Map<String,Double> neighbours=graph.get(curNode);
        if(neighbours.containsKey(targetNode)){
            ret=product*neighbours.get(targetNode);
        }
        else{
            for(Map.Entry<String,Double> pair:neighbours.entrySet()){
                String nextNode=pair.getKey();
                if(visited.contains(nextNode))
                continue;
                ret=backtrackEvaluate(graph,nextNode,targetNode,product*pair.getValue(),visited);
                if(ret!=-1.0) break;
            }
        }
        visited.remove(curNode);
        return ret;
    }
}