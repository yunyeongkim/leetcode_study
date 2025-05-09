class Solution {
   
     public List<String> letterCasePermutation(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        List<String> ans = new ArrayList<>(s.length());
        dfs(s, 0, sb, ans);
        return ans;
    }

    private void dfs(String s, int idx, StringBuilder sb, List<String> answer) {
        if (idx == s.length()) {
            answer.add(sb.toString());
            return;
        }

        char c = s.charAt(idx);
        
        if (65 <= c && c <= 122) {
            sb.append(Character.toUpperCase(c));
            dfs(s, idx + 1, sb, answer);
            sb.setLength(sb.length() - 1);
            
            sb.append(Character.toLowerCase(c));
            dfs(s, idx + 1, sb, answer);
            sb.setLength(sb.length() - 1);
        }else{
            sb.append(c);
            dfs(s, idx + 1, sb, answer);
            sb.setLength(sb.length() - 1);
        }

    }

}