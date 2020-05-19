package com.example.algorithm.kimJeongHyeon.lv2;

/**
 * URL: https://programmers.co.kr/learn/courses/30/lessons/42584
 * 완료일: 2020.05.17
 * 
 * <p>문제 설명</p>
 * 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.
 * 
 * 제한사항
 * prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
 * prices의 길이는 2 이상 100,000 이하입니다.
 * 입출력 예
 * prices	return
 * [1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]
 * 입출력 예 설명
 * 1초 시점의 ₩1은 끝까지 가격이 떨어지지 않았습니다.
 * 2초 시점의 ₩2은 끝까지 가격이 떨어지지 않았습니다.
 * 3초 시점의 ₩3은 1초뒤에 가격이 떨어집니다. 따라서 1초간 가격이 떨어지지 않은 것으로 봅니다.
 * 4초 시점의 ₩2은 1초간 가격이 떨어지지 않았습니다.
 * 5초 시점의 ₩3은 0초간 가격이 떨어지지 않았습니다.
 * ※ 공지 - 2019년 2월 28일 지문이 리뉴얼되었습니다.
 * 
 * 
 * <p>필기</p>
 * 문제 카테고리가 스택/큐 인것으로 보아 스택이나 큐를 활용하는 문제로 보인다.
 * 그러나 나는 스택, 큐를 활용하는 방법을 떠올리지 못하고, 2중 반복문으로
 * 비교횟수를 줄이기 위한 코드를 넣긴 했으나, 무려 시간복잡도가 O^2 나 되는 방법을 선택했다.
 * 
 * @author kaeao
 *
 */
public class StockPrice {
	
	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		
		for(int i=0; i<prices.length; i++) {
			answer[i] = 0;
			for(int j=i+1; j<prices.length; j++) {
				if(prices[i] <= prices[j]) {
					answer[i]++;
				} else {
					answer[i]++;
					break;
				}
			}
		}
		
		return answer;
	}
}
