package com.example.algorithm.one1214;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.algorithm.one1214.level1.StringHandlingBasic;

public class StringHandlingBasicTest {
	private StringHandlingBasic test;
	
	@BeforeEach
	void init() {
		test = new StringHandlingBasic();
	}
	
	@Test
	@DisplayName("문자열 다루기 기본 Test")
	public void StringHandlingBasic_Test() {
		boolean answer = false;
		
		String s = "a1234";
		answer = test.solution(s);
		assertEquals(answer, false);
		
		s = "1234";
		answer = test.solution(s);
		assertEquals(answer, true);
	}

}
