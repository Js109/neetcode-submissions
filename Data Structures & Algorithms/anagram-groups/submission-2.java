class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            // frequence array for 26 small letters
            int[] count = new int[26];
            for(int i = 0; i< str.length(); i++) {
                count[str.charAt(i) - 'a']++;
            }

        // Convert array to unique String
        StringBuilder sb = new StringBuilder();
        for(int c : count) {
            sb.append('#').append(c);
        }
        String frequencyKey = sb.toString();

        if(!map.containsKey(frequencyKey)) {
            map.put(frequencyKey, new ArrayList<>());
        }
        map.get(frequencyKey).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
