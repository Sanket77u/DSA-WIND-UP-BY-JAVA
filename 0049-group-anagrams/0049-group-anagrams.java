class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagram = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            List<String> list = new ArrayList<>();
            int frequency[] = new int[26];
            for (int j = 0; j < strs[i].length(); j++) {
                frequency[strs[i].charAt(j) - 'a']++;
            }

            if (anagram.containsKey(Arrays.toString(frequency))) {
                anagram.get(Arrays.toString(frequency)).add(strs[i]);
            } else {
                list.add(strs[i]);
                anagram.put(Arrays.toString(frequency), list);

            }

        }
        return new ArrayList<>(anagram.values());
    }
}