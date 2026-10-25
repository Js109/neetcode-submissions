class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.equals(t)) {
            return true;
        }
        if(s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> charCounterS = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charCounterS.put(c, charCounterS.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> charCounterT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            charCounterT.put(c, charCounterT.getOrDefault(c, 0) + 1);
        }

        return charCounterS.equals(charCounterT);
    }
}
