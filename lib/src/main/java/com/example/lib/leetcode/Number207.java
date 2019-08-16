package com.example.lib.leetcode;


import java.util.LinkedList;
import java.util.Queue;

public class Number207 {

    public static void main(String[] args) {
        Number207 number207 = new Number207();
        int[][] prerequisites = new int[][]{{1, 0}};
        System.out.print(number207.canFinishByDfs(2, prerequisites));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue<Integer> queue = new LinkedList<>();
        LinkedList<Integer>[] adj = createGraph(numCourses, prerequisites);
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                inDegree[adj[i].get(j)]++;
            }
        }
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int number = 0;
        while (!queue.isEmpty()) {
            int k = queue.poll();
            number++;
            for (int i = 0; i < adj[k].size(); i++) {
                int j = adj[k].get(i);
                inDegree[j]--;
                if (inDegree[j] == 0) {
                    queue.offer(j);
                }
            }
        }
        return number == numCourses;
    }

    public static boolean isCircle;

    public boolean canFinishByDfs(int numCourses, int[][] prerequisites) {
        isCircle = false;
        LinkedList<Integer>[] adj = createGraph(numCourses, prerequisites);
        int[] tag = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (tag[i] != -1) {
                dfs(i, adj, tag);
            }
        }
        return !isCircle;
    }

    public void dfs(int k, LinkedList<Integer>[] adj, int[] tag) {
        tag[k] = 1;
        for (int i = 0; i < adj[k].size(); i++) {
            int j = adj[k].get(i);
            if (tag[j] == 1) {
                isCircle = true;
                return;
            } else if (tag[j] == -1) {
            } else {
                dfs(j, adj, tag);
            }
        }
        tag[k] = -1;
    }


    public LinkedList<Integer>[] createGraph(int numCourses, int[][] prerequisites) {
        LinkedList<Integer>[] adj = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new LinkedList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        return adj;
    }
}
