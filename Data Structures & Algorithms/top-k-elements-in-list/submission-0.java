class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> uniqueNums = new ArrayList<>(countMap.keySet());

        uniqueNums.sort((a, b) -> countMap.get(b) - countMap.get(a));

        int[] result = new int[k];
        for(int i = 0; i<k; i++) {
            result[i] = uniqueNums.get(i);
        }

        return result;
    }
}
