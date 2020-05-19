package com.example.algorithm.kimJeongHyeon.lv1;

/**
 * URL: https://programmers.co.kr/learn/courses/30/lessons/49993
 * 완료일: 2020.05.19
 * 
 * <p>문제 설명</p>
 * 선행 스킬이란 어떤 스킬을 배우기 전에 먼저 배워야 하는 스킬을 뜻합니다.
 * 
 * 예를 들어 선행 스킬 순서가 스파크 → 라이트닝 볼트 → 썬더일때, 썬더를 배우려면 먼저 라이트닝 볼트를 배워야 하고, 라이트닝 볼트를 배우려면 먼저 스파크를 배워야 합니다.
 * 
 * 위 순서에 없는 다른 스킬(힐링 등)은 순서에 상관없이 배울 수 있습니다. 따라서 스파크 → 힐링 → 라이트닝 볼트 → 썬더와 같은 스킬트리는 가능하지만, 
 * 썬더 → 스파크나 라이트닝 볼트 → 스파크 → 힐링 → 썬더와 같은 스킬트리는 불가능합니다.
 * 
 * 선행 스킬 순서 skill과 유저들이 만든 스킬트리1를 담은 배열 skill_trees가 매개변수로 주어질 때, 가능한 스킬트리 개수를 return 하는 solution 함수를 작성해주세요.
 * 
 * 제한 조건
 * 스킬은 알파벳 대문자로 표기하며, 모든 문자열은 알파벳 대문자로만 이루어져 있습니다.
 * 스킬 순서와 스킬트리는 문자열로 표기합니다.
 * 예를 들어, C → B → D 라면 CBD로 표기합니다
 * 선행 스킬 순서 skill의 길이는 1 이상 26 이하이며, 스킬은 중복해 주어지지 않습니다.
 * 
 * skill_trees는 길이 1 이상 20 이하인 배열입니다.
 * skill_trees의 원소는 스킬을 나타내는 문자열입니다.
 * skill_trees의 원소는 길이가 2 이상 26 이하인 문자열이며, 스킬이 중복해 주어지지 않습니다.
 * 
 * 입출력 예
 * skill    skill_trees                          return
 * "CBD"    ["BACDE", "CBADF", "AECB", "BDA"]    2
 * 
 * 입출력 예 설명
 * BACDE: B 스킬을 배우기 전에 C 스킬을 먼저 배워야 합니다. 불가능한 스킬트립니다.
 * CBADF: 가능한 스킬트리입니다.
 * AECB: 가능한 스킬트리입니다.
 * BDA: B 스킬을 배우기 전에 C 스킬을 먼저 배워야 합니다. 불가능한 스킬트리입니다.
 * 
 * <p>필기</p>
 * return+1 조건과 반대 조건을 명확히 정리하고 알고리즘을 만들어나가는 것이 중요하다.
 * 본문을 자세히 읽고 각 조건을 철저하게 이해해야한다.
 * 이 문제는 스킬트리가 하나도 없거나, 모든 스킬트리가 다 있지 않더라도 앞부분부터 빠진 부분 없이 모두 있으면 성공.
 * 그 외의 모든 경우의 수는 실패로 간주해야한다.
 * 
 * 내 알고리즘의 논리
 * 
 * 스킬이 있는 경우.
 * 스킬 중 첫번째 인자가 트리 내 있으면, 트리를 검색하면서 스킬의 다음 인자들이 순서대로 잘 트리 안에 있는지 검사한다.
 * 첫번째 인자만 들어있는 상태거나, 중간에 빠진 것 없이 스킬이 잘 들어가 있으면 true를 유지한체로 루프를 종료한다.
 * 
 * 스킬이 없는 경우.
 * 스킬의 첫번째 인자가 없으면 다른 인자들도 트리 내 들어있지 않은지 검사한다. 모든 스킬이 트리 안에 없는 것으로 확인되면 true, 그렇지 않으면 false를 반환한다.
 * 
 * @author kaeao
 *
 */
public class SkillTree {
	
	/**
	 * TODO 거지같은 소스코드입니다. 개선된 버전으로 업데이트할 수 있도록 하겠습니다.
	 * 
	 * @param skill
	 * @param skill_trees
	 * @return
	 */
    public int solution1(String skill, String[] skill_trees) {
		int answer = 0;
		String[] skillArray = skill.split("");
        
		for (int i = 0; i < skill_trees.length; i++) {
            boolean flow = true;
			if(skill_trees[i].contains(skillArray[0])) {
				for (int j = 1; j < skillArray.length; j++) {
					if(skill_trees[i].contains(skillArray[j]) && (!skill_trees[i].contains(skillArray[j-1]) || skill_trees[i].indexOf(skillArray[j]) <= skill_trees[i].indexOf(skillArray[j-1]))) {
                        flow = false;
                        break;
                    }
				}
			} else {
                for(int j = 1; j < skillArray.length; j++) {
                    if(skill_trees[i].contains(skillArray[j])) flow = false;
                }
            }
            if(flow) answer++;
		}
		return answer;
	}
}