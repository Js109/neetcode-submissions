class Solution {
    public boolean hasDuplicate(int[] nums) {
        if(nums == null) return false;

        Set<Integer> storage = new HashSet<>();
        for(int num : nums) {
            if(!storage.add(num)) {
                return true;
            }
        }
        return false;
    }
}