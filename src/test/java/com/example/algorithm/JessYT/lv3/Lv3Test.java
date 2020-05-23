package com.example.algorithm.JessYT.lv3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class Lv3Test {
    private Lv3 practice;

    @BeforeEach
    void init() {
        practice = new Lv3();
    }

    @Test
    @DisplayName("종이접기 테스트...")
    public void 종이접기_Test() {
        int n = 1;
        int[] answer = practice.종이접기(n);
        assertThat(answer, is(new int[]{0}));

        n = 2;
        answer = practice.종이접기(n);
        assertThat(answer, is(new int[]{0,0,1}));

        n = 3;
        answer = practice.종이접기(n);
        assertThat(answer, is(new int[]{0,0,1,0,0,1,1}));

    }

    @Test
    @DisplayName("입국심사 test..")
    public void 입국심사_Test() {
        int n = 6;
        int[] times = {7,10};
        long answer = practice.입국심사(n, times);

        assertEquals(answer, 28);
    }

}