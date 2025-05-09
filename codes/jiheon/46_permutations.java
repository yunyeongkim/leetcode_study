class Solution {  
    public List<List<Integer>> permute(int[] nums) {  
        List<List<Integer>> answer = new ArrayList<>();  
  
        dfs(answer, new ArrayList<>(), nums, new boolean[nums.length]);  
        return answer;  
    }  
  
    private void dfs(List<List<Integer>> answer, List<Integer> cur, int[] nums, boolean[] used) {  
  
        if (cur.size() == nums.length) {  
            answer.add(new ArrayList<>(cur));  
            return;  
        }  
  
        for (int i = 0; i < nums.length; i++) {  
            if (used[i]) continue;  
            cur.add(nums[i]);  
            used[i] = true;  
            dfs(answer, cur, nums, used);  
            cur.remove(cur.size() - 1);  
            used[i] = false;  
        }  
    }  
}