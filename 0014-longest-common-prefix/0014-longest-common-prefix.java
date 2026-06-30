class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans = strs[0];
        for (int i = 0; i < strs.length; i++) {
            int len = Math.min(ans.length(), strs[i].length());
            int j = 0;

            while (j < len && ans.charAt(j) == strs[i].charAt(j)) {
                j++;
            }

            ans = ans.substring(0, j);
        }
        return ans;
    }
}
