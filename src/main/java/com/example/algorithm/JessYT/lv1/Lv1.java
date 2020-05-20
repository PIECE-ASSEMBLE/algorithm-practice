package com.example.algorithm.JessYT.lv1;

import java.util.Arrays;
import java.util.Stack;

public class Lv1 {
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

    public String 완주하지못한선수(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        int i = 0;
        for (i = 0; i < participant.length; i++) {
            if(completion.length == i || !participant[i].equals(completion[i])) 
                break;
        }
        
        return participant[i];
    } 
}