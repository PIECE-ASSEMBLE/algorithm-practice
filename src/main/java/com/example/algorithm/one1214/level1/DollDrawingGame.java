package com.example.algorithm.one1214.level1;

import java.util.Stack;

/**
 * @author one
 * @date 2020. 5. 31.
 * @see https://programmers.co.kr/learn/courses/30/lessons/64061
 * 
 * [문제 설명]
 * 게임 화면의 격자의 상태가 담긴 2차원 배열 board와 인형을 집기 위해 크레인을 작동시킨 위치가 담긴 배열 moves가 매개변수로 주어질 때, 
 * 크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수를 return 하도록 solution 함수를 완성해주세요.
 * 
 * [제한사항]
 * board 배열은 2차원 배열로 크기는 5 x 5 이상 30 x 30 이하입니다.
 * board의 각 칸에는 0 이상 100 이하인 정수가 담겨있습니다.
 * 0은 빈 칸을 나타냅니다.
 * 1 ~ 100의 각 숫자는 각기 다른 인형의 모양을 의미하며 같은 숫자는 같은 모양의 인형을 나타냅니다.
 * moves 배열의 크기는 1 이상 1,000 이하입니다.
 * moves 배열 각 원소들의 값은 1 이상이며 board 배열의 가로 크기 이하인 자연수입니다.
 * 
 * [입출력 예]
 * 							board													moves							return
 * ---------------------------------------------------------------------------------------------------------------------------
 * [[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]				[1,5,3,5,1,2,1,4]					  4
 * ---------------------------------------------------------------------------------------------------------------------------
 */
public class DollDrawingGame {
	
	 public static int solution(int[][] board, int[] moves) {
	        int answer = 0;
	        Stack<Integer> basket = new Stack<>();
	        
	        for(int i=0; i < moves.length; i++) {
	        	int move = moves[i]-1; // 실제 배열의 index는 0부터 시작
	        	for(int j=0; j < board.length; j++) {
	        		if(board[j][move] != 0) { //해당 위치에 인형이 있을 때
	        			if(basket.isEmpty()) { // 바구니가 비어있을 때
	        				basket.push(board[j][move]); // 바구니에 인형을 넣어준다.
	        			} else { // 바구니가 비어있지 않을 때 
	        				if(basket.peek() == board[j][move]) { // 바구니 맨 위에 있는 인형과 집어올린 인형이 같으면
	        					basket.pop(); // 바구니에서 같은 인형 2개를 사라지게 하고
	        					answer += 2; // 인형 2개가 사라졌으니 2개를 증가시킨다.
	        				} else { // 바구니 맨 위에 있는 인형과 집어올린 인형이 같지 않으면
	        					basket.push(board[j][move]);	// 바구니에 집어올린 인형을 넣어준다.
	        				}
	        			}
	        			
	        			board[j][move] = 0; // board에 존재하는 인형을 집어올려서 바구니에 넣어줬으면 그 위치에 인형을 없앤다.
	        			break; // 크레인의 위치를 바꾼다.
	        		} 
	        	}
	        }
	        
	        return answer;
	 	}
	}
