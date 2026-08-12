class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2) {
            return new int[0];
        }
        
        Map<Integer, Integer> resultMap = new HashMap<>();

        for(int i =0; i < nums.length; i++) {
            int difference;
            difference = target - nums[i];

            if(resultMap.containsKey(difference)) {
                return new int[] { resultMap.get(difference), i };
            } else {
                resultMap.put(nums[i], i);
            }
        }
        return new int[0]; 
    }
}
