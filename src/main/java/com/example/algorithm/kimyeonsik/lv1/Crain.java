package com.example.algorithm.kimyeonsik.lv1;

import java.util.Stack;

class Paper{
    public static void main(String[] args) {
    	int[][] board = new int [][] {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}	;
    	int[] moves = new int[] {1,5,3,5,1,2,1,4};
        System.out.println(solution(board,moves));
    }
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
	        int temp = 0;
	        Stack<Integer> stack = new Stack<Integer>() ;
	        for(int i = 0; i < moves.length ; i++){
	            int seq = moves[i]-1;
                
	             for(int j = 0; j< board.length; j++){
	                if(board[j][seq] == 0) continue;
	                temp = board[j][seq];
	                board[j][seq] = 0;
	                if(stack.empty() || stack.peek() != temp){
	                    stack.add(temp);
	                } else if (stack.peek() == temp){
	                    stack.pop();
	                    answer += 2;
	                }
	                break;
	            }
	            
	        }
	        
	        return answer;
    }
}