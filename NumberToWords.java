package String;

public class NumberToWords {
	private final String[] Less_Than_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] Tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] Thousands = {"", "Thousand", "Million", "Billion"};
        
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        String words = "";
        int i = 0;
        while(num > 0) {
            if(num % 1000 != 0) words = helper(num % 1000) + Thousands[i] + " " + words;
            i++;
            num = num / 1000;
        }
        
        return words.trim();
    }
    
    private String helper(int num) {
        if(num == 0) return "";
        if(num < 20) return Less_Than_20[num] + " ";
        if(num < 100) return Tens[num / 10] + " " + helper(num % 10);
        return Less_Than_20[num / 100] + " " + "Hundred" + " " + helper(num % 100);
    }
}
