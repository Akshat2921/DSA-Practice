class Solution {
    public long gcdSum(int[] nums) {
        int array_length=nums.length;
        int[] prefixGcd=new int[array_length];  //O(n)

        int maximum_element_so_far=0;
        for(int i=0;i<array_length;i++){    //O(n)
            maximum_element_so_far=Math.max(maximum_element_so_far,nums[i]);
            prefixGcd[i]=gcd(maximum_element_so_far,nums[i]);  
            //TC: O(log(min(a,b))) per call 
            //     → yaha max value 10^9 tak ho sakti hai, toh ~O(log(10^9))
        }
        // Poore loop ki TC = n * O(log(maxVal)) = O(n log(maxVal))
        // Poore loop ki SC = O(log(maxVal)) — kyunki har call complete hone ke baad 
        //           stack clear ho jata hai, peak sirf ek call ka rehta hai
        
        Arrays.sort(prefixGcd);   // TC: O(n log n) 
         // SC: O(log n) — sorting ke internal recursion/partition ke liye auxiliary space
        //     (kabhi kabhi O(n) bhi ho sakta hai worst case mein, but average O(log n))

        
        long sum=0;
        int left=0,right=array_length-1;

        while(left<right){    //Loop (n/2) baar chalega → O(n)
            
            sum+=gcd(prefixGcd[left],prefixGcd[right]);
            // TC: O(log(min(a,b))) per call → O(log(maxVal)) since values already ≤ maxVal
            // SC: O(log(maxVal)) per call — recursion stack (temporary, per call)

            left++;
            right--;
        }
        // Poore while loop ki TC = (n/2) * O(log(maxVal)) = O(n log(maxVal))
        // Poore while loop ki SC = O(log(maxVal)) — peak stack space ek call ka
        
        return sum;
    }
    int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
// Single gcd() call:
    // TC: O(log(min(a,b)))  — Euclidean algorithm, numbers har 2 steps mein 
    //                          approx aadhe ho jaate hain
    // SC: O(log(min(a,b)))  — recursion stack depth utni hi hoti hai jitne steps
    //                          (recursive hai, iterative nahi, isliye stack use hota hai)
}

// Overall explanation
// Time Complexity: O(n log n)
// Space Complexity: O(n)