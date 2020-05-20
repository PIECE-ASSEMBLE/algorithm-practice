package com.example.algorithm.one1214.level1;

/**
 * @author chohn
 * @date 2020. 5. 20.
 * @see https://programmers.co.kr/learn/courses/30/lessons/12918
 * 
 * [문제 설명]
 * 문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요. 
 * 예를 들어 s가 a234이면 False를 리턴하고 1234라면 True를 리턴하면 됩니다.
 * 
 * [제한 사항]
 * s는 길이 1 이상, 길이 8 이하인 문자열입니다.
 * 
 * [입출력 예]
 *   s			return
 * --------------------
 * "a234"		 false
 * "1234"		 true
 * --------------------
 * 
 * 
 * [내 풀이]
 * 1. 정규식을 만든다.
 *     1-1. ^ : 패턴의 시작
 *     1-2. [0-9] : 0에서 9까지의 수
 *     1-3. .$ : 패턴의 종료
 * 
 * 2. 문자열의 길이가 4 혹은 6이라고 했으므로 if문에 해당 조건을 설정한다.
 * 
 * 3. s가 정규식 reg와 매치되면 true를 리턴하고 아니라면 false를 리턴한다.
 *  
 * 4. s의 길이가 4 혹은 6을 넘어가는 경우가 있을 수 있기 때문에 if문 밖에서 false를 리턴한다. 
 */
public class StringHandlingBasic {
	
	public boolean solution(String s) {
        String reg = "^[0-9]*$";
        
        if(s.length() == 4 || s.length() == 6) {
            return s.matches(reg);
        } 
        
        return false;
        
    }

}
