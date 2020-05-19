package com.example.algorithm.kimJeongHyeon.lv1;

import java.util.Arrays;

/**
 * URL: https://programmers.co.kr/learn/courses/30/lessons/42748
 * 완료일: 2020.05.17
 * 
 * <p>문제 설명</p>
 * 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.
 * 
 * 예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면
 * 
 * array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
 * 1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
 * 2에서 나온 배열의 3번째 숫자는 5입니다.
 * 배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때,
 * commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 * 
 * 제한사항
 * array의 길이는 1 이상 100 이하입니다.
 * array의 각 원소는 1 이상 100 이하입니다.
 * commands의 길이는 1 이상 50 이하입니다.
 * commands의 각 원소는 길이가 3입니다.
 * 
 * 입출력 예
 * array
 * [1, 5, 2, 6, 3, 7, 4]
 * commands
 * [[2, 5, 3], [4, 4, 1], [1, 7, 3]]
 * return
 * [5, 6, 3]
 * 
 * 
 * 입출력 예 설명
 * [1, 5, 2, 6, 3, 7, 4]를 2번째부터 5번째까지 자른 후 정렬합니다. [2, 3, 5, 6]의 세 번째 숫자는 5입니다.
 * [1, 5, 2, 6, 3, 7, 4]를 4번째부터 4번째까지 자른 후 정렬합니다. [6]의 첫 번째 숫자는 6입니다.
 * [1, 5, 2, 6, 3, 7, 4]를 1번째부터 7번째까지 자릅니다. [1, 2, 3, 4, 5, 6, 7]의 세 번째 숫자는 3입니다.
 * 
 * 
 * <p>필기</p>
 * [반드시 체크] 'n번째 수'와 'n번째 인덱스'는 분명히 다르다.
 * copyOfRange 등의 범위를 지정하는 함수는 첫번째 파라미터는 그 인덱스에 해당하는 아이템부터 두번째 파라미터에 해당하는 인덱스 전까지만 포함한다.
 * n번째 수부터 m번째 수까지 구하려면 n ~ m+1 이 되어야 하는 것이다. 그러나 '번째 수'는 1부터 시작하고 '인덱스'는 0부터 시작하므로
 * 
 * n번째 수부터 m번째 수 = n-1 ~ m 이 되어야 한다.
 * 
 * @author kaeao
 *
 */
public class KthNumber {
	
	public boolean test() {
		boolean result = false;
		
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2,5,3}, {4,4,1}, {1,7,3}};
		
		try {
			this.solution(array, commands);
			result = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		
		for(int i=0; i<commands.length; i++) {
			int[] copyArray = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
			Arrays.sort(copyArray);
			answer[i] = copyArray[commands[i][2]-1];
		}
		
		System.out.print("[");
		for(int i=0; i<answer.length; i++) {
			System.out.print(answer[i] + ", ");
		}
		System.out.print("]\n");
		
		return answer;
	}
	
}
