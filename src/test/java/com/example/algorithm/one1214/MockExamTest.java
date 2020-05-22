package com.example.algorithm.one1214;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.algorithm.one1214.level1.MockExam;

public class MockExamTest {
	private MockExam me;
	
	@BeforeEach
	void init() {
		me = new MockExam();
	}
	
	@Test
	public void MockExam_Test() {
		int[] param = {1, 2, 3, 4, 5};
		
		int[] answers = me.solution(param);
		int[] aa = {1};
		
		assertEquals(answers, aa);
		
	}
	
}
