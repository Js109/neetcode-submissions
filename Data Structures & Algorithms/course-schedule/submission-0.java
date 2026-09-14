class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /*For each course, we calculate the number of its prerequisites (the in-degree). Courses with 0 prerequisites are placed in a queue. We work through the queue and, after each course is completed, reduce the number of outstanding prerequisites for the subsequent courses.*/
        
        // initialize Adjazenz list and in-degree array
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i<numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];

        // Construct the graph & count the in-degrees
        // prerequisites[i] = [a, b] means: b -> a
        for(int[] pair: prerequisites) {
            int course = pair[0];
            int prereq = pair[1];

            graph.get(prereq).add(course);
            inDegree[course]++;
        }

        // Fill queue with courses with no prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i<numCourses; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // bfs
        int completedCourses = 0;

        while(!queue.isEmpty()) {
            int current = queue.poll();
            completedCourses++;

            // courses that depend on current
            for(int nextCourse : graph.get(current)) {
                inDegree[nextCourse]--;

                // all prerequisites fullfilled, add to queue
                if(inDegree[nextCourse] == 0) {
                    queue.add(nextCourse);
                }
            }
        }

        // Check if all courses have been completed
        return completedCourses == numCourses;
    }
}
