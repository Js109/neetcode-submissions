class Solution {
    public int climbStairs(int n) {
        // bottom up approach --> You turn the logic on its head: first you solve the smallest sub-problems (n=1, n=2) and then, using a simple loop, build up the final result from them
        if(n <= 2) {
            return n;
        }

        int first = 1; // way for stair 1
        int second = 2; // way for stair 2
        int current = 0;

        for(int i = 3; i <= n; i++) {
            current = first + second;
            first = second;
            second = current;
        }

        return current;
    }
}
