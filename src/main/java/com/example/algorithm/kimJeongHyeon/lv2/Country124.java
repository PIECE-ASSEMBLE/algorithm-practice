package com.example.algorithm.kimJeongHyeon.lv2;

import java.util.ArrayList;

/**
 * 124 나라의 숫자 (풀이 일시: 2020.06.23)
 * URL: https://programmers.co.kr/learn/courses/30/lessons/12899
 * 
 * <p>풀이</p>
 * 추후 풀이 코멘트 작성하겠습니다.
 * 
 * @author kim.jeong.hyeon
 *
 */
public class Country124 {
	public String MyFailedSolution(int n) {
		String[] stringList = {"1", "2", "4"};
		String answer = "";
		ArrayList<Integer> left = new ArrayList<>();
		
		while(n >= 3) {
			left.add(n % 3);
			n = n / 3;
		}
		left.add(n);
		
		for(int i=left.size()-1; i>=0; i--) {
			answer += stringList[left.get(i)];
		}
		
		return answer;
	}
	
	public String solution(int n) {
		String[] stringList = {"4", "1", "2"};
		String answer = "";
		ArrayList<Integer> left = new ArrayList<>();
		
		while(n > 0) {
            if(n % 3 != 0) {
                left.add(n % 3);
            } else {
                left.add(0);
                n--;
            }
            n = n / 3;
		}
		
		for(int i=left.size()-1; i>=0; i--) {
			answer += stringList[left.get(i)];
		}
		
		return answer;
	}
	
}
