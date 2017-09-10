package LC42;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Class4 {
	public static void main(String[] args) {
		Class4 solution = new Class4();
		int[] nums = {1,12,-5,-6,50,3};
		List<String> dict = Arrays.asList("cat", "cattl", "bat", "rat");
		System.out.println(solution.replaceWords(dict  , "the cattle was rattled by the battery"));
	}
	
	public String replaceWords(List<String> dict, String sentence) {
        String[] strs = sentence.split("\\s+");
        
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>(dict);      
        
        for(String str : strs) {
            
            boolean flag = false;
            
            for(int i=1; i<=str.length(); i++) {
                if(set.contains(str.substring(0, i))) {
                    sb.append(str.substring(0, i) + " ");
                    flag = true;
                    break;
                }
            }
            
            if(!flag) sb.append(str + " ");
        }
        
        return sb.toString().trim();
    }
}