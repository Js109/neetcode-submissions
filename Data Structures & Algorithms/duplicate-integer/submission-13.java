class Solution {
    public boolean hasDuplicate(int[] nums) {
        if(nums == null) {
            return false;
        }
        Set<Integer> storage = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if (storage.contains(nums[i])) {
                return true;
            }
            storage.add(nums[i]);
        }
        return false;
    }
}