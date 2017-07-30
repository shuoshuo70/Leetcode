package String;

public class ComplexNumberMultiply {
	public String complexNumberMultiply(String a, String b) {
        String[] str1 = a.split("\\+");
        String[] str2 = b.split("\\+");
        
        int[] arr1 = new int[2];
        int[] arr2 = new int[2];
        for(int i=0; i<2; i++) {
            arr1[i] = Integer.parseInt(str1[i].replace("i", ""));
            arr2[i] = Integer.parseInt(str2[i].replace("i", ""));
        }
        
        long part1 = (long) arr1[0] * arr2[0] - arr1[1] * arr2[1];
        long part2 = (long) arr1[0] * arr2[1] + arr1[1] * arr2[0];
        
        return part1 + "+" + part2  + "i";
    }
}
