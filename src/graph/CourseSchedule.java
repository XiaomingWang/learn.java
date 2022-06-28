package graph;


import java.util.*;

/**
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 *
 *
 * Example 1:
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 *
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());
        // Get the indegree and adjacency of every course.
        for(int[] cp : prerequisites) {
            indegrees[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }
        // Get all the courses with the indegree of 0.
        for(int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) queue.add(i);
        }
        // BFS Top Sort.
        while(!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for(int cur : adjacency.get(pre)) {
                indegrees[cur] -= 1;
                if (indegrees[cur] == 0) queue.add(cur);
            }
        }
        return numCourses == 0;
    }


    public static void main(String[] args) {
        /**
         *
         * 0 - 1 - 4 - 3 - 2
         *      \        /
         *       \     /
         *          5
         *
         */
        int[][] prerequisites = {{5, 1}, {3, 4}, {2, 5}, {2, 3}, {4, 1}, {1, 0}};
        int numCourses = 6;

        CourseSchedule solution = new CourseSchedule();
        System.out.println(solution.canFinish(numCourses, prerequisites));


        int[] indegrees = new int[numCourses];
        for(int[] cp : prerequisites) {
            indegrees[cp[0]]++;
        }

        System.out.println(Arrays.toString(indegrees));
    }


}
