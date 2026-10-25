class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.equals(t)) {
            return true;
        }
        if(s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> charCounterS = new HashMap<Character, Integer>();
        for(int i = 0; i<s.length(); i++) {
            if(!charCounterS.containsKey(s.charAt(i))) {
                charCounterS.put(s.charAt(i), 1);
            } else {
                int currentCount = charCounterS.get(s.charAt(i));
                charCounterS.put(s.charAt(i), currentCount+1); 
            }
        }

        Map<Character, Integer> charCounterT = new HashMap<Character, Integer>();
        for(int i = 0; i<t.length(); i++) {
            if(!charCounterT.containsKey(t.charAt(i))) {
                charCounterT.put(t.charAt(i), 1);
            } else {
                int currentCount = charCounterT.get(t.charAt(i));
                charCounterT.put(t.charAt(i), currentCount+1); 
            }
        }

        return charCounterS.equals(charCounterT);
    }
}
