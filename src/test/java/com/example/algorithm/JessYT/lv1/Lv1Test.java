package com.example.algorithm.JessYT.lv1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Lv1Test {
    
    private Lv1 practice;

    @BeforeEach
    void init() {
        practice = new Lv1();
    }

    @Test
    @DisplayName("크레인 인형 뽑기 게임 Test...")
    public void 크레인인형뽑기게임_Test(){
        int [][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        int answer = practice.크레인인형뽑기게임(board, moves);

        assertEquals(answer, 4);
    }

    @Test
    @DisplayName("완주하지 못한 선수 Test...")
    public void 완주하지못한선수_Test() {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        String answer = practice.완주하지못한선수(participant, completion);
        assertEquals(answer, "leo");
    }
    
    @Test
    @DisplayName("문자열내림차순으로배치하기 Sort 안쓰고 풀어보기")
    public void 문자열내림차순으로배치하기1_Test() {
        String s = "Zbcdefg";
        	
        String answer = practice.문자열내림차순으로배치하기1(s);
        
        assertEquals(answer, "gfedcbZ");
    }

    @Test
    @DisplayName("Arrays 객체의 sort의 소중함..")
    public void 문자열내림차순으로배치하기2_Test() {
        String s = "Zbcdefg";
        	
        String answer = practice.문자열내림차순으로배치하기2(s);
        
        assertEquals(answer, "gfedcbZ");
    }
}