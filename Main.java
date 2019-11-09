import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4}; // return 4
		
		System.out.println(new Solution().solution(board, moves));
	}

}

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
