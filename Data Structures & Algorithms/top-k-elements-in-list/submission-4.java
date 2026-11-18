class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for(int i = 0; i<nums.length; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
        }

        // Min-Heap (PriorityQueue) sorted for frequency
        // - WAS WIRD GESPEICHERT? Die eigentlichen Zahlen (Keys der countMap), nicht ihre Häufigkeit.
        // - WIE WIRD PRIORISIERT? Über countMap::get holen wir die Häufigkeit (Value) als Vergleichswert.
        // - WARUM EIN MIN-HEAP? Weil das Element mit der GERINGSTEN Häufigkeit ganz oben steht.
        //   Wenn die Queue größer als k wird, fliegt genau dieses "schwächste" Element sofort raus (.poll()).
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(countMap.get(a), countMap.get(b)));

        // add element and limit size to k
        for(int key : countMap.keySet()) {
            pq.add(key);

            // Wenn mahr als k Elemente drin sind, fliegt schwächstes Element raus
            if(pq.size() > k) {
                pq.poll();
            }
        }

        // verbleibende k Elemente in Ergebnis-Array schreiben
        int[] result  = new int[k];
        for(int i = 0; i<k; i++) {
            result[i] = pq.poll();
        }

        return result;
    }
}
