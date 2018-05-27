package LC60;

import java.util.Stack;

/**
 * We are given an array asteroids of integers representing asteroids in a row.

 For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

 Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 * Created by shuoshu on 2017/11/26.
 */
public class Class3 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            if (stack.isEmpty() || asteroid > 0) {
                stack.push(asteroid);
                continue;
            }

            while (true) {
                int element = stack.peek();
                if (element < 0) {
                    stack.push(asteroid);
                    break;
                }

                if (element > -asteroid) {
                    break;
                }
                else if (element < -asteroid) {
                    stack.pop();
                }
                else {
                    stack.pop();
                    break;
                }

                if (stack.isEmpty()) {
                    stack.push(asteroid);
                    break;
                }
            }
        }

        int l = stack.size();
        int[] ans = new int[l];

        while (!stack.isEmpty()) {
            ans[--l] = stack.pop();
        }

        return ans;
    }
}
