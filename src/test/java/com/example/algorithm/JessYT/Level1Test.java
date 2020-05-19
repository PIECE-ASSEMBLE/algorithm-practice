package com.example.algorithm.JessYT;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Level1Test {
    
    private Level1 practice;

    @BeforeEach
    void init() {
        practice = new Level1();
    }

    @Test
    @DisplayName("크레인 인형 뽑기 게임 Test...")
    public void 크레인인형뽑기게임_Test(){
        int [][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        int answer = practice.크레인인형뽑기게임(board, moves);

        assertEquals(answer, 4);
    }
}