class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) {
            return List.of();
        }

        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            // convert word in array and sort
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedKey = new String(charArray);

            // If key not existing yet, create new empty List
            if(!map.containsKey(sortedKey)) {
                map.put(sortedKey, new ArrayList<>());
            }

            // add original word to fitting key
            map.get(sortedKey).add(str);            
        }

        return new ArrayList<>(map.values());
    }
}
