package com.example.algorithm.kimJeongHyeon.lv1;


/**
 * URL: https://programmers.co.kr/learn/courses/30/lessons/42840
 * 완료일: 2020.05.20
 * 
 * <p>문제 설명</p>
 * 수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
 * 
 * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
 * 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
 * 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
 * 
 * 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 * 
 * 제한 조건
 * 시험은 최대 10,000 문제로 구성되어있습니다.
 * 문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
 * 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
 * 
 * 입출력 예
 * answers        return
 * [1,2,3,4,5]    [1]
 * [1,3,2,4,2]    [1,2,3]
 * 
 * 입출력 예 설명
 * 입출력 예 #1
 * 수포자 1은 모든 문제를 맞혔습니다.
 * 수포자 2는 모든 문제를 틀렸습니다.
 * 수포자 3은 모든 문제를 틀렸습니다.
 * 따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.
 * 
 * 입출력 예 #2
 * 모든 사람이 2문제씩을 맞췄습니다.
 * 
 * <p>필기</p>
 * 각 배열의 길이로 나눈 나머지 값을 이용해 정답을 체크합니다.
 * 
 * @author kaeao
 *
 */
public class MockTest {
	public int[] solution(int[] answers) {
		int[] hit = { 0, 0, 0 };
		int[][] routine = { { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 }, { 2, 1, 2, 3, 2, 4, 2, 5 }, { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 } };
		int max = 0, cnt = 0, index = 0;

		for (int i = 0; i < answers.length; i++) {
			for (int j = 0; j < routine.length; j++) {
				if (answers[i] == routine[j][i % routine[j].length]) {
					hit[j]++;
					max = (max < hit[j]) ? hit[j] : max;
				}
			}
		}

		for (int i = 0; i < hit.length; i++) {
			if (max == hit[i])
				cnt++;
		}

		int[] answer = new int[cnt];

		for (int i = 0; i < hit.length; i++) {
			if (max == hit[i] && index <= answer.length) {
				answer[index] = i + 1;
				index++;
			}
		}
		return answer;
	}
}
