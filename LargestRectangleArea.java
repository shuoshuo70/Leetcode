package Arrays;

import java.util.Stack;

public class LargestRectangleArea {
	public static void main(String[] args) {
		LargestRectangleArea solution = new LargestRectangleArea();
		int[] nums = {2,1,5,6,2,3};
		System.out.println(solution.largestRectangleArea(nums));
	}
	
	public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = 0;
        
        for(int i=0; i<=heights.length; i++) {
            if(stack.isEmpty() || heights[stack.peek()] <= (i == heights.length ? 0: heights[i])) {
                stack.push(i);
            } else {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (stack.isEmpty() ? i : i - stack.peek() - 1));
                i--;
            }
        }
        
        return maxArea;
    }
}
