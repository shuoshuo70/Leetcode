package LC51;

import java.util.TreeSet;

/**
 * There is a garden with N slots. In each slot, there is a flower. The N flowers will bloom one by one in N days. In each day, there will be exactly one flower blooming and it will be in the status of blooming since then.

Given an array flowers consists of number from 1 to N. Each number in the array represents the place where the flower will open in that day.

For example, flowers[i] = x means that the unique flower that blooms at day i will be at position x, where i and x will be in the range from 1 to N.

Also given an integer k, you need to output in which day there exists two flowers in the status of blooming, and also the number of flowers between them is k and these flowers are not blooming.

If there isn't such day, output -1
 * @author shuoshu
 *
 */
public class Class4 {
	public static void main(String[] args) {
		Class4 solution = new Class4();
		int[] flowers = {1,  3, 2};
		System.out.println(solution.kEmptySlots(flowers , 1));
	}
	
	public int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        
        for (int flower : flowers) {
            set.add(flower);
            
            Integer right = set.ceiling(flower + 1);
            if (right != null && right - flower == k + 1) {
                return set.size();
            }

            Integer left = set.floor(flower - 1);
            if (left != null && flower - left == k + 1) {
                return set.size();
            }
        }
        
        return -1;
    }
}
