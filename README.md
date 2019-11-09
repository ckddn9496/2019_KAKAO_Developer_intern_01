# 2019_KAKAO_Developer_intern_01

## 2019 카카오 개발자 겨울 인턴십 코딩테스트 1번

### 1. 문제설명

input으로 `N * N` 크기의 `map`을 뜻하는 int형 이차원 배열과 `moves`라는 int형 배열이 들어온다. `map`에서 `0`은 빈 공간을 뜻하며 `1` ~ `100`까지의 숫자는 각기 다른 인형의 모양을 의미하며 같은 숫자는 같은 모양의 인형을 나타낸다. `moves`은 `map`에서 인형을 뽑을 크레인을 내릴 열을 의미하며, 가장 위에 존재하는 인형을 뽑아온다. 뽑은 인형은 바구니에 담기며 바구니에 같은 종류의 인형 두 개가 연속해서 쌓이게 되면 두 터뜨려지면서 바구니에서 사리지게 된다. 이때 터뜨려서 사라진 인형의 개수를 return하는 문제

### 2. 풀이

`moves`배열의 갯수만큼 크레인을 작동시켜 `map`의 해당 열 꼭대기 부터 `0`이 아닌 값을 찾는다. 만약 찾는다면 바구니에 인형을 넣는 행위를 위해 스택에 인형을 넣는다. 이때 발생하는 경우는 다음과 같다.

1.  바구니가 비었을 때
  인형을 넣는다
  
2.  바구니가 비어있지 않을 때

    2.1.  바구니의 가장 꼭대기 인형이 넣을 인형과 같은 종류일 때
      인형을 넣지 않고 바구니의 꼭대기 인형을 터뜨린다.

    2.1.  종류가 같지 않을 때
      인형을 넣는다.

2.1 경우에 인형은 두 개씩 터트려 지며 이 행위에서 `answer`의 값을 `2`증가시킨다.

위과정을 반복하며 모든 `moves`를 수행하면 `answer`를 return한다.

```java

class Solution {
    public int solution(int[][] board, int[] moves) {
    	Stack<Integer> s = new Stack<>();
    	
    	int answer = 0;
    	
    	for (int col : moves) {
    		for (int rowIdx = 0; rowIdx < board.length; rowIdx++) {
    			if (board[rowIdx][col - 1] == 0)
    				continue;
    			else {
    				int val = board[rowIdx][col - 1];
    				if (!s.isEmpty()) {
    					if (s.peek() == val) {
    						s.pop();
    						answer += 2;
    					} else {
    						s.add(val);
    					}
    				} else {
        				s.add(val);
    				}
    				board[rowIdx][col - 1] = 0;
    				break;
    			}
    		}
    	}
    	
        return answer;
    }
}

```
