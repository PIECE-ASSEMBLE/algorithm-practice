package com.example.algorithm.JessYT.lv3;

import java.util.LinkedList;
import java.util.Queue;

public class Lv3 {
    public int[] 종이접기(int n) {
        Queue<Integer> new_queue = new LinkedList<Integer>();

        new_queue.offer(0);
        for (int i = 1; i < n; i++) {
            Queue<Integer> old_queue = new LinkedList<Integer>();

            boolean flag = true;
            while(!new_queue.isEmpty()) {
                if(flag) {
                    old_queue.offer(0);
                    old_queue.offer(new_queue.poll());
                    old_queue.offer(1);
                    flag = !flag;
                } else {
                    old_queue.offer(new_queue.poll());
                    flag = !flag;
                }
            }
            new_queue.addAll(old_queue);
        }
        return new_queue.stream().mapToInt(Integer::intValue).toArray();
    }
}