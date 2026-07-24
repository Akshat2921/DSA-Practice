class Solution {
    public boolean uniqueOccurrences(int[] arr) {
                /*
        Map<Integer,Integer> map=new HashMap<>();
        for(int elem:arr){
            if(!map.containsKey(elem)){
              map.put(elem,1);  
            }
            else map.put(elem,map.get(elem)+1);
        }
        Set<Integer> freq_Set=new HashSet<>();
        for(int freq:map.values()){
            if(freq_Set.contains(freq))
            return false;

            freq_Set.add(freq);
        }
        return true;
                */

        int[] freq_arr=new int[2001];
        for(int elem:arr){
            freq_arr[elem+1000]++;
        }
        Arrays.sort(freq_arr);

        for(int i=1;i<2001;i++){
            if(freq_arr[i]!=0 && freq_arr[i]==freq_arr[i-1])
            return false;
        }
        return true;
    }
}