package com.example.algorithm.one1214;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.algorithm.one1214.level1.StringDescending;

public class StringDescendingTest {
	private StringDescending test;
	
	@BeforeEach
	void init() {
		test = new StringDescending();
	}
	
	@Test
	@DisplayName("문자열 내림차순으로 배치하기")
	public void StringDescending_Test() {
		String s = "Zbcdefg";
		String answer = "";
		
		answer = test.solution(s);
		
		assertEquals(answer, "gfedcbZ");
	}

}
