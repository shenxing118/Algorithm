package com.example.lib.leetcode;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Number210 {

    public static void main(String[] args) {
        Number210 number207 = new Number210();
        int[][] prerequisites = new int[][]{{1, 0}};
        System.out.print(number207.findOrderByDfs(2, prerequisites));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        int[] result = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int k = queue.poll();
            result[index++] = k;
            for (int i = 0; i < adj[k].size(); i++) {
                int j = adj[k].get(i);
                inDegree[j]--;
                if (inDegree[j] == 0) {
                    queue.offer(j);
                }
            }
        }
        return index == numCourses ? result : new int[0];
    }

    public static boolean isCircle;

    public int[] findOrderByDfs(int numCourses, int[][] prerequisites) {
        isCircle = false;
        LinkedList<Integer>[] adj = createGraphReverse(numCourses, prerequisites);
        List<Integer> result = new ArrayList<>();
        int[] tag = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (tag[i] != -1) {
                dfs(i, adj, tag, result);
            }
        }
        if (isCircle){
            return new int[0];
        }else {
            int[] resultArray = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                resultArray[i] = result.get(i);
            }
            return resultArray;
        }
    }

    public void dfs(int k, LinkedList<Integer>[] adj, int[] tag, List<Integer> result) {
        tag[k] = 1;
        for (int i = 0; i < adj[k].size(); i++) {
            int j = adj[k].get(i);
            if (tag[j] == 1) {
                isCircle = true;
                return;
            } else if (tag[j] == 0) {
                dfs(j, adj, tag, result);
            }
        }
        tag[k] = -1;
        result.add(k);
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

    public LinkedList<Integer>[] createGraphReverse(int numCourses, int[][] prerequisites) {
        LinkedList<Integer>[] adj = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new LinkedList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adj[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        return adj;
    }
}
