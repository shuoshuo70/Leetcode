package LC41;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Class2 {

	public static void main(String[] args) {
		Class2 solution = new Class2();
		List<String> logs = Arrays.asList("0:start:0", "1:start:2", "1:end:5",
				"0:end:6");
		int[] res = solution.exclusiveTime(2, logs);
		for(int i=0; i<res.length; i++) {
			System.out.println(res[i]);
		}
		
	}

	public int[] exclusiveTime(int n, List<String> logs) {
		int[] ans = new int[n];
		if (logs.size() == 0)
			return ans;

		Stack<Element> stack = new Stack<>();
		for (String log : logs) {
			String[] strs = log.split(":");
			int id = Integer.parseInt(strs[0]);
			int time = Integer.parseInt(strs[2]);
			if (strs[1].equals("start")) {
				if (stack.isEmpty())
					stack.push(new Element(id, time));
				else {
					Element e = stack.peek();
					ans[e.id] += time - e.time;
					stack.push(new Element(id, time));
				}
			} else {
				Element e = stack.pop();
				ans[id] += time - e.time + 1;
				if (!stack.isEmpty()) {
					e = stack.pop();
					e.time = time+1;
					stack.push(new Element(e.id, e.time));
				}
			}
		}

		return ans;
	}

	class Element {
		int id;
		int time;

		Element(int id, int time) {
			this.id = id;
			this.time = time;
		}
	}
}
