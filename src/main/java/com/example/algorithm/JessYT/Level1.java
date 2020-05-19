package com.example.algorithm.JessYT;

import java.util.Stack;

public class Level1 {
    public int 크레인인형뽑기게임(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> s = new Stack<Integer>();
        for (int move : moves) {
            for (int i = 0; i < board.length; i++) {
                int b = board[i][move-1];
                if(b != 0) {
                    board[i][move-1] = 0;
                    if(!s.empty() && s.peek() == b) {
                        s.pop();
                        answer += 2;
                    } else 
                        s.push(b);
                    break;
                }
            }
        }
        return answer;
    }
}