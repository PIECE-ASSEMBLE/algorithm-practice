package com.example.algorithm.kimyeonsik.lv3;

import java.util.Arrays;

class Paper{
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5)));
    }
    public static int[] solution(int n){
        int sum = 0;
		for(int i = 0; i < n; i++) {
			sum += Math.pow(2,i);
		}
		int[] answer = new int[sum];
		int[] conAns = null;
		int count = 0;
		int arrCount = 0;
		if (n > 1) {
			conAns = solution(n - 1);
		} 

		for (int i = 0; i < sum; i++) {
			if (i % 2 == 0) {
				answer[i] = count == 0 ? count++ : count--;
			} else {
				answer[i] = conAns[arrCount++];
			}
		}

		return answer;
    }

    
}