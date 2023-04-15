public class Solution {
	static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static int[] nums, operators, order;

// order[1...N-1]에 연산자들이 순서대로 저장될 것이다
	static void rec_func(int k) {
		if (k == N) { // 모든 연산자들을 전부 나열하는 방법을 찾은 상태
			// 정한 연산자 순서대로 계산해서 정답을 갱신하기
			// 완성된 식에 맞게 계산을 해서 정답에 갱신하는 작업
			int value = calculator();
			max = Math.max(max, value);
			min = Math.min(min, value);
		} else { 
			// k번째 연산자는 무엇을 선택할 것인가?
			for(int cand = 1; cand <= 4; cand++) {
				if(operators[cand]>=1) {
					operators[cand]--;
					order[k] = cand;
					rec_func(k+1);
					operators[cand]++;
					order[k] = 0;
				}
			}
			// 4가지의 연산자들 중에 뭘 쓸 것인지 선택하고 재귀호출하기
		}
	}

// 완성된 식에 맞게 계산을 해서 정답에 갱신하는 작업
	static int calculator() {
		// nums, order
		int value = nums[1];
		for (int i = 1; i <= N - 1; i++) {
			// value, order[i], nums[i+1]
			if (order[i] == 1) // +
				value = value + nums[i + 1];
			if (order[i] == 2) // -
				value = value - nums[i + 1];
			if (order[i] == 3) // x
				value = value * nums[i + 1];
			if (order[i] == 4) // /
				value = value / nums[i + 1];
		}
	}
	return value;
}


// ------------------------------------------------------



public class Solution {
	static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static int[] nums, operators, order;

// order[1...N-1]에 연산자들이 순서대로 저장될 것이다
	static void rec_func(int k, int value) {
		if (k == N) { // 모든 연산자들을 전부 나열하는 방법을 찾은 상태
			// 정한 연산자 순서대로 계산해서 정답을 갱신하기
			// 완성된 식에 맞게 계산을 해서 정답에 갱신하는 작업
//			int value = calculator();
			max = Math.max(max, value);
			min = Math.min(min, value);
		} else { 
			// k번째 연산자는 무엇을 선택할 것인가?
			for(int cand = 1; cand <= 4; cand++) {
				if(operators[cand]>=1) {
					operators[cand]--;
					order[k] = cand;
					//int new_value = calculator(value, cand, nums[k+1]);
					//rec_func(k+1, new_value);					
					rec_func(k+1, calculator(value, cand, nums[k+1]));
					operators[cand]++;
					order[k] = 0;
				}
			}
			// 4가지의 연산자들 중에 뭘 쓸 것인지 선택하고 재귀호출하기
		}
	}

// 피연산자 2개와 연산자가 주어졌을 때 계산해주는 함수
	static int calculator(int operand1, int operator, int operand2) {
		// nums, order
			// value, order[i], nums[i+1]
			if (operator == 1) // +
				return operand1 + operand2;
			else if (operator == 2) // -
				return operand1 - operand2;
			else if (operator == 3) // *
				return operand1 * operand2;
			else // /
				return operand1 / operand2;

		}
	
	public static void main(String[] args) {
		rec_func(1,nums[1]);
	}
}

