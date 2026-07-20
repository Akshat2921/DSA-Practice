class Solution {
    int n;

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        //     //Time: O(m·n) Space: O(m·n) for the output/flat array

        //     int m=grid.length;
        //     int n=grid[0].length;
        //     int total=m*n;
        //     k%=total;

        //     int[] flat=new int[total];
        //     int idx = 0;

        //     for(int i=0;i<m;i++){
        //         for(int j=0;j<n;j++){
        //             // int oldIndex=i*n+j;
        //             // int newIndex=(oldIndex+k)%total;
        //             // flat[newIndex]=grid[i][j];
        //             flat[idx++]=grid[i][j];
        //         }
        //     }
        //     rotate(flat,k);

        //     List<List<Integer>> result=new ArrayList<>();
        //     idx=0;
        //     for(int i=0;i<m;i++){
        //         List<Integer> row=new ArrayList<>();
        //         for(int j=0;j<n;j++){
        //             row.add(flat[idx++]);
        //         }
        //         result.add(row);
        //     }
        //     return result;
        // }
        //  public void rotate(int[] nums, int k) {
        //     k = k % nums.length;
        //     reverse(nums, 0, nums.length);
        //     reverse(nums, 0, k);
        //     reverse(nums, k, nums.length);
        // }
        // public void reverse(int[] nums, int i, int j) {
        //     j--;
        //     while (i < j) {
        //         int temp = nums[i];
        //         nums[i] = nums[j];
        //         nums[j] = temp;
        //         i++;
        //         j--;
        //     }

        int m = grid.length;
        n = grid[0].length;

        rotate(grid, k);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(grid[i][j]);
            }
            result.add(row);
        }

        return result;
    }

    public void rotate(int[][] grid, int k) {
        int total = grid.length * n;
        k = k % total;
        reverse(grid, 0, total);
        reverse(grid, 0, k);
        reverse(grid, k, total);
    }

    public void reverse(int[][] grid, int i, int j) {
        j--;
        while (i < j) {
            int temp = get(grid, i);
            set(grid, i, get(grid, j));
            set(grid, j, temp);
            i++;
            j--;
        }
    }

    private void set(int[][] grid, int index, int value) {
        grid[index / n][index % n] = value;
    }

    private int get(int[][] grid, int index) {
        return grid[index / n][index % n];
    }
}