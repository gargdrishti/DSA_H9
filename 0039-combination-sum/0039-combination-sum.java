import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(0, candidates, target, current, ans);

        return ans;
    }

    private void backtrack(int start, int[] candidates, int target,
                           List<Integer> current,
                           List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            current.add(candidates[i]);
            backtrack(i, candidates, target - candidates[i],
                      current, ans);

            current.remove(current.size() - 1);
        }
    }
}