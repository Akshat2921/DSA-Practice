class Solution {
    public int maxProduct(int[] nums) {
        int max_element=0;
        int second_larget_element=0;

        for(int elem:nums){
            if(elem>max_element){
                second_larget_element=max_element;
                max_element=elem;
            }else if(elem>second_larget_element){
                second_larget_element=elem;
            }
        }
        return (max_element-1)*(second_larget_element-1);
    }
}