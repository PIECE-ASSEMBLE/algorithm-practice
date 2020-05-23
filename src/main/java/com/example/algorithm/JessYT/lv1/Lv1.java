package com.example.algorithm.JessYT.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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

    public String 문자열내림차순으로배치하기1(String s) {
        List<String> copy = new ArrayList<String>(Arrays.asList(s.split("")));
        StringBuilder stringbuilder = new StringBuilder();

        while(copy.size() > 1) {
            String min = copy.get(0);
            for (int i = 1; i < copy.size(); i++) {
                if(min.compareTo(copy.get(i)) < 0) {
                    min = copy.get(i);
                }
            }
            copy.remove(min);
            stringbuilder.append(min);
        };

        stringbuilder.append(copy.get(0));

        return stringbuilder.toString();
    }

    public String 문자열내림차순으로배치하기2(String s) {
        String[] stringArray = s.split("");
        Arrays.sort(stringArray, Collections.reverseOrder());
        List<String> strings = new ArrayList<String>(Arrays.asList(stringArray));

        StringBuilder stringbuilder = new StringBuilder();
        for (String string : strings) {
            stringbuilder.append(string);
        }

        return stringbuilder.toString();
    };
}