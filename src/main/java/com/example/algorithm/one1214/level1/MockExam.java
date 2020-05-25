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
 * 
 * [내 풀이]
 * 1. 각 사람이 맞춘 정답의 개수(즉, 점수) answerCnt를 설정한다. 세명의 사람이므로 사이즈는 3으로 설정한다.
 * 2. 수포자 1, 2, 3에 대한 정답 패턴 배열 one, two, three를 설정한다.
 * 3. 최고 점수 max를 설정한다.
 * 4. 정답 answers가 배열이므로 이 크기만큼 반복문을 돌려서 수포자1-3의 정답 패턴과 정답을 비교한다.
 * 5. 0에서 1씩 순차적으로 늘어나는 i에서 배열의 크기 one~three.length를 나눈 나머지 인덱스와 정답들의 i번째 데이터들과 비교한다.
 * 6. cf) i % one.length는 indexOutOfBounds 익셉션이 발생하지 않는다.
 * 7. 만약 수포자들의 정답 패턴과 정답들이 일치하다면 맞춘 정답의 개수(점수) answerCnt를 증가시킨다.
 * 8. 더불어 최고 점수보다 맞춘 개수(점수)가 더 높다면 최고점수 max에 맞춘 개수 answerCnt 값을 할당한다.
 * 9. 최고 점수를 받은 사람은 여러명일 수 있으므로 Integer 타입 List인 winnerList를 생성한다.
 * 10. 수포자들이 맞은 점수 answerCnt의 길이만큼 반복문을 돌려서 최고점수 max와 그 값이 같으면 winnerList에 i+1을 추가한다.
 * 11. i+1인 이유는 return할 값이 1부터 시작되기 때문이다.
 * 12. return할 answer에 winnerList 크기만큼 배열을 생성하고 winnerList에서 뽑은 값을 answer에 담기 위해 포문을 돌린다.
 * 13. answer를 리턴한다.
 * 
 *  cf) ArrayList를 생성하지 않고 풀 수 있는 방법 찾아볼 것.. for문을 세번이나 돌리니까 코드가 별로임
 */
public class MockExam {
	public static void main(String[] args) {
		int[] answers = {1, 3, 2, 4, 2};
		int[] end = solution(answers);	
	}
	
	public static int[] solution(int[] answers) {
		int[] answer = {};
		int[] answerCnt = new int[3];	// 맞춘 정답의 개수(점수)
		int[] one = {1, 2, 3, 4, 5};
		int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		int max = 0; // 정답을 맞춘 개수 중 가장 높은 수(최고 점수)
		
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
