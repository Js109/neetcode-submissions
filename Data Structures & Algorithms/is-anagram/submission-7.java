class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.equals(t)) {
            return true;
        }
        if(s.length() != t.length()) {
            return false;
        }

        int[] counts = new int[26];

        for(int i = 0; i<s.length(); i++) {
            int indexS = getIndex(s.charAt(i));
            int indexT = getIndex(t.charAt(i));

            counts[indexS]++;
            counts[indexT]--;
        }

        for(int count : counts) {
            // if there is a difference at specific index of s and t --> no anagram
            if(count != 0) return false;
        }
        return true;
    }

    private int getIndex(char c) {
    return c - 'a'; // Rechnet z.B. 'a' -> 0, 'b' -> 1 um
}
}
