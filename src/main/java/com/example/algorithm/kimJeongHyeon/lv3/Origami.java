package com.example.algorithm.kimJeongHyeon.lv3;

/**
 * URL: https://programmers.co.kr/learn/courses/30/lessons/62049 완료일: 2020.05.22
 * 
 * <p>
 * 문제 설명
 * </p>
 * 직사각형 종이를 n번 접으려고 합니다. 이때, 항상 오른쪽 절반을 왼쪽으로 접어 나갑니다. 다음은 n = 2인 경우의 예시입니다.
 * 
 * image
 * 
 * 먼저 오른쪽 절반을 왼쪽으로 접습니다.
 * 
 * image
 * 
 * 다시 오른쪽 절반을 왼쪽으로 접습니다.
 * 
 * image
 * 
 * 종이를 모두 접은 후에는 종이를 전부 펼칩니다. 종이를 펼칠 때는 종이를 접은 방법의 역순으로 펼쳐서 처음 놓여있던 때와 같은 상태가
 * 되도록 합니다. 위와 같이 두 번 접은 후 종이를 펼치면 아래 그림과 같이 종이에 접은 흔적이 생기게 됩니다.
 * 
 * image
 * 
 * 위 그림에서 ∨ 모양이 생긴 부분은 점선(0)으로, ∧ 모양이 생긴 부분은 실선(1)으로 표시했습니다.
 * 
 * 종이를 접은 횟수 n이 매개변수로 주어질 때, 종이를 절반씩 n번 접은 후 모두 펼쳤을 때 생기는 접힌 부분의 모양을 배열에 담아
 * return 하도록 solution 함수를 완성해주세요.
 * 
 * 제한사항 종이를 접는 횟수 n은 1 이상 20 이하의 자연수입니다. 종이를 접었다 편 후 생긴 굴곡이 ∨ 모양이면 0, ∧ 모양이면 1로
 * 나타냅니다. 가장 왼쪽의 굴곡 모양부터 순서대로 배열에 담아 return 해주세요. 입출력 예 n result 1 [0] 2 [0,0,1]
 * 3 [0,0,1,0,0,1,1] 입출력 예 설명 입출력 예 #1 종이의 오른쪽 절반을 왼쪽으로 한번 접었다 펴면 아래 그림과 같이 굴곡이
 * 생깁니다.
 * 
 * image
 * 
 * 따라서 [0]을 return 하면 됩니다.
 * 
 * 입출력 예 #2 문제의 예시와 같습니다.
 * 
 * 입출력 예 #3 종이를 절반씩 세 번 접은 후 다시 펼치면 아래 그림과 같이 굴곡이 생깁니다.
 * 
 * image
 * 
 * 따라서 [0,0,1,0,0,1,1]을 return 하면 됩니다.
 * 
 * <p>
 * 풀이
 * </p>
 * 급하게 푸느라 코드 최적화도 안되어 있습니다.
 * 
 * <p>
 * [Point]
 * </p>
 * <ol>
 * <li>처음 접으면 한 가운데 V 형태로 종이가 접힌다.</li>
 * <li>n번 접은 종이의 접힌 자국은 (n-1)번 + V형태 + (n-1)번을 뒤집은 형태로 이루어진다.</li>
 * </ol>
 * 
 * @author kaeao
 *
 */
public class Origami {
	public static int[] solution(int n) {
		int[] answer;
		if (n == 1) {
			answer = new int[] { 0 };
		} else {
			int[] prev = solution(n - 1);
			answer = new int[prev.length * 2 + 1];

			int i = 0;

			while (i < answer.length) {
				if (i <= prev.length)
					answer[i] = (i == prev.length) ? 0 : prev[i];
				else
					answer[i] = prev[(answer.length - 1) - i] == 0 ? 1 : 0;
				i++;
			}
		}
		return answer;
	}

	/**
	 * 소스코드 + 코멘트
	 * 
	 * @param n
	 * @return
	 */
	public int[] solutionWithCommant(int n) {
		int[] answer;

		// 한 번 접은 종이의 상태는 V 자국 하나 뿐이기에, [0]을 반환합니다.
		if (n == 1) {
			answer = new int[] { 0 };
		} else {

			// 접은 수가 2번 이상(n)인 경우, 재귀호출을 합니다.
			int[] prev = solution(n - 1);

			// "n번 접은 종이의 접힌 자국은 (n-1)번 + V형태 + (n-1)번을 뒤집은 형태로 이루어진다" 는 조건에 의해
			// n번 접은 종이의 접힌 자국의 갯수는 'f(n)'은 '2 * f(n-1) + 1' 입니다.
			// ex) 현재 종이상태 = (이전 종이상태) + (가운데 'V' 모양으로 접힌 자국) + (이전 종이상태를 반대로 뒤집은 모양)
			answer = new int[prev.length * 2 + 1];

			// 접힌 자국의 방향을 표기하기 위해 WHILE문을 수행합니다.
			int i = 0;

			while (i < answer.length) {
				// n-1번 접은 자국 수보다 작은 경우 해당 자국(0 or 1)의 정보를 그대로 입력합니다.
				// 또한 가장 가운데 자리에 0을 삽입하기 위한 분기도 추가했습니다.
				if (i <= prev.length)
					answer[i] = (i == prev.length) ? 0 : prev[i];

				// 마지막으로 이전에 접은 종이 자국과 반대되는 모양을 입력합니다.
				// ex) 001010 => 110101
				else
					answer[i] = prev[(answer.length - 1) - i] == 0 ? 1 : 0;
				i++;
			}
		}
		return answer;
	}
}
