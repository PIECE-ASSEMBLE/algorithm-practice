package com.example.algorithm.kimJeongHyeon.lv2;

import java.util.Stack;

/**
 * 쇠막대기 (풀이 일시: 2020.06.22)
 * URL : https://programmers.co.kr/learn/courses/30/lessons/42585
 * 
 * <p>풀이</p>
 * 쇠막대기에 대한 정보들을 스택에 담습니다. 레이저가 스택을 통과할 때, 스택 안에 쇠막대기의 왼쪽 끝 부분만 있고 오른쪽 끝 부분이 아직 없으면 레이져가 쇠막대기를 잘랐다고 판단합니다.
 * 오른쪽 끝 부분에 대한 정보가 나타나면, 반드시 쇠막대가 한 조각이 더 있다고 판단하고 쌍을 이루는 쇠막대기의 좌측 끝 부분에 대한 정보를 스택에서 제거합니다.
 * 코드에 대한 직접적인 설명만 적어서 외계어나 개소리처럼 들립니다. 이 부분은 스터디 때 사람이 알아들을 수 있는 언어로 풀어서 상세하게 설명드리겠습니다.
 * 
 * @author kim.jeong.hyeon
 *
 */
public class IronBar {
	public int solution(String arrangement) {
		arrangement.replaceAll("()", "1");
		String[] arrangeList = arrangement.split("");
		int answer = 0;
		Stack<Integer> stack = new Stack<>();
		for(String i : arrangeList) {
			if(i.equals("(")) {
				stack.push(1);
			} else if(i.equals(")")) {
				stack.pop();
				answer++;
			} else {
				answer += stack.size();
			}
		}
		return answer;
	}
}
