class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int arr_length=nums.length;
        HashSet<Integer> pair_XOR_Set=new HashSet<>();
        for(int i=0;i<arr_length;i++){
            for(int j=i;j<arr_length;j++){    // total iterations = n(n+1)/2 ≈ O(n²)
                pair_XOR_Set.add(nums[i]^nums[j]);
            }
        }
        // Space = O(min(n², V)) — kyunki set mein sirf distinct XOR values store hote hain, jo n² se zyada nahi ho sakte, aur V se bhi zyada nahi ho sakte (kyunki utne hi possible values hain).

        HashSet<Integer> unique_Triplet_XOR_Set=new HashSet<>();
        for(int piarwiseXOR:pair_XOR_Set){    // outer loop = |pair_XOR_Set| times, worst case min(n², V)
            for(int element=0;element<arr_length;element++){   // inner loop = n times
                unique_Triplet_XOR_Set.add(nums[element]^piarwiseXOR);
            }
        }
        return unique_Triplet_XOR_Set.size();
    }
    // Time = O(n × min(n², V)) → worst case O(n³) (jab V ≥ n², i.e. value range bada hai)
    // Space = O(min(n × |pair_XOR_Set|, V)) → practically O(V), kyunki triplet XOR bhi usi range mein hi rahega.
}