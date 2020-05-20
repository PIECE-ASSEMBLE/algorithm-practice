package com.example.algorithm.one1214.level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author chohn
 * @date 2020. 5. 20.
 * @see https://programmers.co.kr/learn/courses/30/lessons/12917
 * 
 * [문제 설명]
 * 문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
 * s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
 * 
 * [제한 사항]
 * str은 길이 1 이상인 문자열입니다.
 * 
 * [입출력 예]
 * 	  s		   return
 * -------------------
 * Zbcdefg     gfedcbZ
 * -------------------
 * 
 * [내 풀이]
 * s의 길이가 1 이상일 때, 문자열 s의 길이만큼 반복문을 돌린다.
 * charAt으로 단어 각각을 ch에  담는다.
 * list에 ch 각각을 계속 담아준다.
 * 
 * Collections 클래스에서 제공하는 reverse로 list를 정렬한다.
 * 역순(reverse)으로 정렬된 값이 gfedcbZ가 된다.
 * StringBuffer answer에 list 각각의 인덱스에 담겨있는 g, f, e....를 추가한다.
 * answer를 문자열로 바꿔 리턴한다.
 */
public class StringDescending {
	
	public String solution(String s) {
        StringBuffer answer = new StringBuffer();
        List<Character> list = new ArrayList<>();
        
        if(s.length() > 0) {
            for(int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                list.add(ch);
            }
            
            Collections.reverse(list);
            
            for(int i=0; i < list.size(); i++) {  
                answer.append(list.get(i));
            }
        }
        
        return answer.toString();
    }

}
