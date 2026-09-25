import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        backtrack(nums, visited, current, ans);

        return ans;
    }

    private void backtrack(int[] nums, boolean[] visited,
                           List<Integer> current,
                           List<List<Integer>> ans) {

        // All numbers are used
        if (current.size() == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            // Skip if already used
            if (visited[i]) {
                continue;
            }

            // Choose
            visited[i] = true;
            current.add(nums[i]);

            // Explore
            backtrack(nums, visited, current, ans);

            // Backtrack
            current.remove(current.size() - 1);
            visited[i] = false;
        }
    }
}