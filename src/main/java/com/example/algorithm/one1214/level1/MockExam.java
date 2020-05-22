package com.example.algorithm.one1214.level1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chohn
 * @date 2020. 5. 21.
 * @see https://programmers.co.kr/learn/courses/30/lessons/42840
 * 
 * [문제 설명]
 * 수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
 * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
 * 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
 * 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
 * 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 * 
 * [제한 조건]
 * 시험은 최대 10,000 문제로 구성되어있습니다.
 * 문제의 정답은 1, 2, 3, 4, 5 중 하나입니다.
 * 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
 * 
 * [입출력 예]
 *     answer               return
 *------------------------------------     
 * [1, 2, 3, 4, 5]            [1]
 * [1, 3, 2, 4, 2]         [1, 2, 3]
 * -----------------------------------
 * 
 * [입출력 예 설명]
 * 입출력 예 #1
 * 수포자 1은 모든 문제를 맞혔습니다.
 * 수포자 2는 모든 문제를 틀렸습니다.
 * 수포자 3은 모든 문제를 틀렸습니다.
 * 따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.
 * 
 * 입출력 예 #2
 * 모든 사람이 2문제씩을 맞췄습니다.
 */
public class MockExam {
	public static void main(String[] args) {
		int[] answers = {1, 3, 2, 4, 2};
		int[] dd = solution(answers);
		
		
	}
	
	public static int[] solution(int[] answers) {
		int[] answer = {};
		int[] answerCnt = new int[3];	// 맞춘 정답의 개수
		int[] one = {1, 2, 3, 4, 5};
		int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		int max = 0; // 정답을 맞춘 갯수 중 가장 높은 수
		for(int i = 0; i < answers.length; i++) {
			if(one[i%one.length] == answers[i]) {
				answerCnt[0]++;	
				max = max < answerCnt[0] ? answerCnt[0] : max;
			}
			if(two[i%two.length] == answers[i]) {
				answerCnt[1]++;
				max = max < answerCnt[1] ? answerCnt[1] : max;
			}
			if(three[i%three.length] == answers[i]) {
				answerCnt[2]++;
				max = max < answerCnt[2] ? answerCnt[2] : max;
			}
		}
		
		System.out.println("one : " + answerCnt[0]);
		System.out.println("two : " + answerCnt[1]);
		System.out.println("three : " + answers[2]);
		
		List<Integer> winnerList = new ArrayList<>();
		
		for(int i = 0; i < answerCnt.length ; i++) {
			if(max == answerCnt[i]) {
				winnerList.add(i+1);
			}
		}
		
		answer = new int[winnerList.size()];
		
		for(int i = 0; i < winnerList.size(); i++) {
			answer[i] = winnerList.get(i);
		}
		
		
		return answer;
	}
	
	

}
