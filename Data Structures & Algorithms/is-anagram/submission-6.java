class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.equals(t)){
            return true;
        }
        if(s.length() != t.length()) {
            return false;
        }

        // fill map for String s with Character and Counter
        Map<Character, Integer> charCounter = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!(charCounter.containsKey(c))){
                charCounter.put(c, 1);
            } else {
                int currentCount = charCounter.get(c);
                charCounter.put(c, currentCount + 1);
            }
        }

        // fill map for String t with Character and Counter
        Map<Character, Integer> charCounterT = new HashMap<>();
        for (int j = 0; j<t.length(); j++) {
            char c = t.charAt(j);
            if(!(charCounterT.containsKey(c))) {
                charCounterT.put(c, 1);
            } else {
                int currentCountT = charCounterT.get(c);
                charCounterT.put(c, currentCountT + 1);
            }
        }

        // Check if both maps are equal
        return charCounter.equals(charCounterT);
    }
}
