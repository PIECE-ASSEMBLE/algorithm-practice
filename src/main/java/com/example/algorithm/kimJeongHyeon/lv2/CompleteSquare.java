package com.example.algorithm.kimJeongHyeon.lv2;

import java.math.BigInteger;

/**
 * URL: https://programmers.co.kr/learn/courses/30/lessons/62048
 * Date: 2020.05.31
 * 
 * 문제 설명
 * 가로 길이가 Wcm, 세로 길이가 Hcm인 직사각형 종이가 있습니다. 
 * 종이에는 가로, 세로 방향과 평행하게 격자 형태로 선이 그어져 있으며, 모든 격자칸은 1cm x 1cm 크기입니다. 
 * 이 종이를 격자 선을 따라 1cm × 1cm의 정사각형으로 잘라 사용할 예정이었는데, 
 * 누군가가 이 종이를 대각선 꼭지점 2개를 잇는 방향으로 잘라 놓았습니다. 
 * 그러므로 현재 직사각형 종이는 크기가 같은 직각삼각형 2개로 나누어진 상태입니다. 
 * 새로운 종이를 구할 수 없는 상태이기 때문에, 이 종이에서 원래 종이의 가로, 세로 방향과 평행하게 
 * 1cm × 1cm로 잘라 사용할 수 있는 만큼만 사용하기로 하였습니다.
 * 가로의 길이 W와 세로의 길이 H가 주어질 때, 사용할 수 있는 정사각형의 개수를 구하는 solution 함수를 완성해 주세요.
 * 
 * 제한사항
 * W, H : 1억 이하의 자연수
 * 
 * 입출력 예
 * W	H	result
 * 8	12	80
 * 
 * 입출력 예 설명
 * 입출력 예 #1
 * 가로가 8, 세로가 12인 직사각형을 대각선 방향으로 자르면 총 16개 정사각형을 사용할 수 없게 됩니다.
 * 원래 직사각형에서는 96개의 정사각형을 만들 수 있었으므로, 96 - 16 = 80 을 반환합니다.
 * 
 * @author kaeao
 *
 */
public class CompleteSquare {
	public long solution(long w, long h) {
		BigInteger width = BigInteger.valueOf(w);
		BigInteger height = BigInteger.valueOf(h);
		long gcd = height.gcd(width).longValue();
		return (w * h) - (w + h - gcd);
	}
	
	/**
	 * 소스코드에 코멘트를 추가한 버전
	 * 
	 * 최대공약수를 사용한 이유:
	 * 수학적인 증명이나 식을 세워서 파악하진 못했습니다.
	 * 몇가지 캐이스를 살펴본 결과, 잘리는 사각형의 갯수와 배치에서 일정한 규칙이 있음을 알아내었습니다.
	 * 찾아낸 규칙은... 
	 * 최대공약수로 각 변을 나눠서 얻은 작은 사각형의 크기마다 잘린 사각형의 패턴이 반복된다는 것이며,
	 * 작은 사각형 내 잘린 종이의 수가 [ 작은 사각형의 높이 * 너비 - 1 ] 이라는 것입니다. 
	 * 
	 * 작은 사각형은 전체 사각형의 (1/최대공약수) 크기이기 때문에,
	 * [ 전체 사각형의 높이 * 너비 - 최대공약수 ]를 하면, 전체 사각형에 대한 잘린 종이의 수를 얻을 수 있을 것이라고 판단했습니다.
	 * 
	 * @param w 
	 * @param h 
	 * 기존 문제는 int형 변수 ㅈ, h를 받지만, 저는 long 타입으로 입력받습니다. 이유는 하단에 설명하겠습니다.
	 * 
	 * @return
	 */
	public long solutionWithCommant(long w, long h) {
		
		/*
		 * < 파라미터 w, h를 int형이 아닌 long 형으로 입력받는 이유 >
		 * 자바는 곱하기, 나누기 연산을 할 때, 계산 결과를 다른 자료형으로 받는다고 선언을 하더라도
		 * 연산 결과는 원래 연산 대상이 되는 자료형으로 계산한 후, 결과 값을 받으려는 결과값으로 캐스팅하여 넘겨줍니다.
		 * 
		 * 예) long result = int a * int b
		 *    1. 먼저 int형 변수에 a*b 결과를 담습니다. (이 부분에서 문제가 발생할 가능성이 있습니다.)
		 *    2. 1번의 값을 long형으로 캐스팅하여 result 변수에 저장합니다.
		 */
		
		// 최대공약수를 쉽게 구할 수 있는 메소드가 BigInteger 클래스에 있으므로 입력받은 두 수를 BigInteger형으로 캐스팅합니다.
		BigInteger width = BigInteger.valueOf(w);
		BigInteger height = BigInteger.valueOf(h);
		
		// 최대공약수를 계산해주는 메소드를 사용합니다. 결과값을 long형으로 반환합니다.
		long gcd = height.gcd(width).longValue();
		
		// 이 부분에서 int형으로 w, h를 받았다면 문제가 발생합니다. w * h의 결과를 일단 in형 변수에 저장하려 할텐데, 그 부분에서 에러가 날 것이기 때문입니다.
		return (w * h) - (w + h - gcd);
	}
}
