package com.example.algorithm.kimJeongHyeon.lv4;

import java.util.HashMap;

/**
 * <p>
 * 문제
 * </p>
 * [본 문제는 정확성과 효율성 테스트 각각 점수가 있는 문제입니다.] 스노우타운에서 호텔을 운영하고 있는 스카피는 호텔에 투숙하려는
 * 고객들에게 방을 배정하려 합니다. 호텔에는 방이 총 k개 있으며, 각각의 방은 1번부터 k번까지 번호로 구분하고 있습니다. 처음에는 모든
 * 방이 비어 있으며 스카피는 다음과 같은 규칙에 따라 고객에게 방을 배정하려고 합니다.
 * 
 * 한 번에 한 명씩 신청한 순서대로 방을 배정합니다. 고객은 투숙하기 원하는 방 번호를 제출합니다. 고객이 원하는 방이 비어 있다면 즉시
 * 배정합니다. 고객이 원하는 방이 이미 배정되어 있으면 원하는 방보다 번호가 크면서 비어있는 방 중 가장 번호가 작은 방을 배정합니다. 예를
 * 들어, 방이 총 10개이고, 고객들이 원하는 방 번호가 순서대로 [1, 3, 4, 1, 3, 1] 일 경우 다음과 같이 방을 배정받게
 * 됩니다.
 * 
 * 원하는 방 번호 배정된 방 번호 1 1 3 3 4 4 1 2 3 5 1 6 전체 방 개수 k와 고객들이 원하는 방 번호가 순서대로 들어있는
 * 배열 room_number가 매개변수로 주어질 때, 각 고객에게 배정되는 방 번호를 순서대로 배열에 담아 return 하도록
 * solution 함수를 완성해주세요.
 * 
 * [제한사항] k는 1 이상 1012 이하인 자연수입니다. room_number 배열의 크기는 1 이상 200,000 이하입니다.
 * room_number 배열 각 원소들의 값은 1 이상 k 이하인 자연수입니다. room_number 배열은 모든 고객이 방을 배정받을 수
 * 있는 경우만 입력으로 주어집니다. 예를 들어, k = 5, room_number = [5, 5] 와 같은 경우는 방을 배정받지 못하는
 * 고객이 발생하므로 이런 경우는 입력으로 주어지지 않습니다.
 * 
 * <p>
 * 필기
 * </p>
 * 주말 동안 자세한 풀이 달아놓겠습니다!
 * 
 * @author kaeao
 *
 */
public class SelectHotelRoom {
	HashMap<Long, Long> map = new HashMap<>();

	private long judgeMuchine(Long call) {
		if (!map.containsKey(call)) {
			map.put(call, call);
			return call;
		} else {
			map.put(call, judgeMuchine(map.get(call) + 1));
			return map.get(call);
		}
	}

	public long[] solution(long k, long[] room_number) {
		long[] answer = new long[room_number.length];

		// 이전에 마지막 방에 대한 예약이 있었는지 파악하기 위한 변수입니다.
		boolean resLastRoom = false;

		// 요청된 예약 배열을 탐색하기 위한 반복문
		for (int i = 0; i < room_number.length; i++) {
			if (room_number[i] < k) { // 마지막 방 예약이 아닌 경우
				answer[i] = this.judgeMuchine(room_number[i]);
			} else if (!resLastRoom) { // 마지막 방 예약인 경우
				answer[i] = room_number[i];
				resLastRoom = true;
			}
		}
		return answer;
	}

	/**
	 * 소스코드 + 코멘트.
	 * 
	 * 예약을 요청받은 방이 이미 차있는 경우, 그보다 숫자가 큰 방을 배정해줘야합니다. 그 경우, (요청받은 번호 + 1) 값을 가지고 다시
	 * 예약 여부를 탐색해야하기 때문에 재귀함수를 사용했습니다.
	 * 
	 * 재귀함수 작성 시 유의사항으로, 탐색경로를 최적화해서 한 번 탐색한 내용을 여러번 반복해서 탐색하지 않도록 만들어야 합니다.
	 * 
	 * @param call
	 * @return
	 */
	private long judgeMuchineWithComment(Long call) {

		// 해당 번호로 예약되지 않았을 경우.
		if (!map.containsKey(call)) {

			// 예약 처리
			map.put(call, call);
			return call;
		} else {

			// 해당 번호로 이미 방이 예약 되어 있는 경우.
			// 예약요청번호+1 의 값으로 다시 탐색하는데, 최종 탐색결과를 다시 요청받은 번호화 함께 저장함으로써,
			// 동일한 요청에 대한 반복 탐색 수행 횟수를 줄였습니다.
			map.put(call, judgeMuchineWithComment(map.get(call) + 1));
			return map.get(call);
		}
	}

	/**
	 * 소스코드 + 코멘트
	 * 
	 * @param k
	 * @param room_number
	 * @return
	 */
	public long[] solutionWithComment(long k, long[] room_number) {
		long[] answer = new long[room_number.length];

		// 이전에 마지막 방에 대한 예약이 있었는지 파악하기 위한 변수입니다.
		boolean resLastRoom = false;

		// 요청된 예약 배열을 탐색하기 위한 반복문
		for (int i = 0; i < room_number.length; i++) {
			if (room_number[i] < k) { // 마지막 방 예약이 아닌 경우
				answer[i] = this.judgeMuchineWithComment(room_number[i]);
			} else if (!resLastRoom) { // 마지막 방 예약이면서, 그 전에 마지막 방 예약이 없었던 경우.
				answer[i] = room_number[i];
				// 다음에 마지막 방 예약 요청이 들어온 경우, 예약 여부를 탐색하지 않고 건너뛰기 위한 설정.
				resLastRoom = true;
			}
		}
		return answer;
	}
}
