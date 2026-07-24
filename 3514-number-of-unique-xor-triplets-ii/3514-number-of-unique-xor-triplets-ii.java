class Solution {
    public int uniqueXorTriplets(int[] nums) {
        //     int arr_length=nums.length;
        //     HashSet<Integer> pair_XOR_Set=new HashSet<>();
        //     for(int i=0;i<arr_length;i++){
        //         for(int j=i;j<arr_length;j++){    // total iterations = n(n+1)/2 ≈ O(n²)
        //             pair_XOR_Set.add(nums[i]^nums[j]);
        //         }
        //     }
        //     // Space = O(min(n², V)) — kyunki set mein sirf distinct XOR values store hote hain, jo n² se zyada nahi ho sakte, aur V se bhi zyada nahi ho sakte (kyunki utne hi possible values hain).

        //     HashSet<Integer> unique_Triplet_XOR_Set=new HashSet<>();
        //     for(int piarwiseXOR:pair_XOR_Set){    // outer loop = |pair_XOR_Set| times, worst case min(n², V)
        //         for(int element=0;element<arr_length;element++){   // inner loop = n times
        //             unique_Triplet_XOR_Set.add(nums[element]^piarwiseXOR);
        //         }
        //     }
        //     return unique_Triplet_XOR_Set.size();
        // }
        // // Time = O(n × min(n², V)) → worst case O(n³) (jab V ≥ n², i.e. value range bada hai)
        // // Space = O(min(n × |pair_XOR_Set|, V)) → practically O(V), kyunki triplet XOR bhi usi range mein hi rahega.

        // Better Approach — Early Termination (Key Insight)

        // Observation: pair_XOR_Set aur unique_Triplet_XOR_Set dono kabhi bhi V (max possible distinct values) se bade nahi ho sakte, chahe tum n element le lo. Toh jaise hi set ka size V tak pahunch jaaye, aage loop chalane ka koi fayda nahi — ruk jao!

        int n = nums.length;
        // max element ka bit-length nikaalo -> V = 2^bits
        int maxVal = 0;
        for (int num : nums)
            maxVal = Math.max(maxVal, num); // O(n)
        int bits = 32 - Integer.numberOfLeadingZeros(maxVal == 0 ? 1 : maxVal); // O(1) — CPU instruction level
        int V = 1 << bits; // theoretical max distinct XOR values

        // Worst case (V bahut bada, kabhi cap nahi lagta): Poora i,j pairs traverse hoga → n(n+1)/2 iterations → O(n²)
        // Best/Average case: Set jaldi V tak pahunch jaata hai → loop early break ho jaata hai → practically O(V) ya usse bhi kam iterations (kyunki set size max V tak hi ja sakta hai, aur ek baar pahunchte hi dono loops ruk jaate hain)
        // Combined: O(min(n², V)) — jo bhi pehle hit ho

        // Space: pairXorSet mein max V distinct elements ja sakte hain (kyunki XOR range hi V tak hai), aur n² se bhi zyada nahi ho sakta → O(min(n², V))

        HashSet<Integer> pairXorSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                pairXorSet.add(nums[i] ^ nums[j]);
                if (pairXorSet.size() == V)
                    break; // early exit
            }
            if (pairXorSet.size() == V)
                break;
        }

        // Worst case: Outer loop min(n², V) baar chalega, inner loop n baar → O(n × min(n², V))
        // Agar V ≥ n²: worst case = O(n³)
        // Agar V < n²: worst case = O(n × V)
        // Best/Average case: tripletXorSet bhi jaldi V tak pahunch ke break kar sakta hai → practically bahut kam iterations
        // Combined: O(min(n × min(n², V), n × V)) — simplify karke: O(n × min(n, V/n... )) — but standard notation mein likhenge: worst-case O(n × min(n², V))

        // Space: tripletXorSet mein max V elements → O(V), jo min(n², V) se compare karo toh O(min(n², V)) hi bound hai (kyunki ye bhi range se bahar nahi ja sakta).
        HashSet<Integer> tripletXorSet = new HashSet<>();
        for (int pairXor : pairXorSet) { // max min(n², V) iterations (pairXorSet ka size)
            for (int k = 0; k < n; k++) {
                tripletXorSet.add(nums[k] ^ pairXor);
                if (tripletXorSet.size() == V)
                    break; // early exit
            }
            if (tripletXorSet.size() == V)
                break;
        }

        return tripletXorSet.size();
    }

    // Ye Kyun
    // Better Hai?
    // Best/Average case: Bahut jaldi V tak pahunch jaata hai (usually O(log V) ya O(n) iterations mein hi, kyunki XOR combinations exponentially naya value discover karte hain shuru mein), toh practically ye O(n² ) ya usse bhi kam ho jaata hai real inputs pe, na ki full O(n³).
    // Worst case guarantee bhi improve hota hai kyunki dono loops hard-capped hain V se — agar V chhota hai (jaise nums range restricted ho), toh ye bahut fast ho jaata hai.
}

// Approach	               Worst-case TC	Notes
// Tumhara original	            O(n³)	   Correct logic, but no early exit
// Early-exit HashSet	O(n²) amortized, O(n³) theoretical worst	Practically bahut fast