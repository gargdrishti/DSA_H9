import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        Arrays.sort(nums);

        boolean[] visited = new boolean[nums.length];

        backtrack(nums, visited, current, ans);

        return ans;
    }

    private void backtrack(int[] nums, boolean[] visited,
                           List<Integer> current,
                           List<List<Integer>> ans) {

        if (current.size() == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            // Already used
            if (visited[i]) {
                continue;
            }

            // Skip duplicates
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
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