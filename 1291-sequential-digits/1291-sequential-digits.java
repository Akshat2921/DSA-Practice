class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        Queue<Integer> queue=new LinkedList<>();
        for(int i=1;i<=8;i++){
            queue.offer(i);
        }
        List<Integer> result=new ArrayList<>();

        while(!queue.isEmpty()){
            int temp=queue.poll();
            if(temp>=low && temp<=high){
                result.add(temp);
            }
            int lastDigit=temp%10;
            if(lastDigit+1<=9){
                queue.offer(temp*10+(lastDigit+1));
            }
        }
        return result;
    }
}