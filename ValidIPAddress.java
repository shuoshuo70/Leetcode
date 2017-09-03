package String;

public class ValidIPAddress {
	public static void main(String[] args) {
		ValidIPAddress solution = new ValidIPAddress();
		System.out.println(solution.validIPAddress("192.0.-0.1"));
	}
	
	public String validIPAddress(String IP) {
        String[] ipv4 = IP.trim().split("\\.");
        String[] ipv6 = IP.trim().split(":");
        
        if(ipv4.length == 4) {
            if(isValidV4(ipv4, IP)) return "IPv4";
        } else if(ipv6.length == 8){
            if(isValidV6(ipv6, IP)) return "IPv6";
        }
        
        return "Neither";
    }
    
    private boolean isValidV4(String[] strs, String s) {
        if(s.charAt(s.length()-1) == '.') return false;
        
        for(int i=0; i<4; i++) {
            if(strs[i] == null || strs[i].length() == 0 || strs[i].length() > 3) return false;
            if(strs[i].startsWith("0")) {
            	if(strs[i].equals("0")) continue;
            	return false;
            }
            
            try{
                int val = Integer.parseInt(strs[i]);
                if(val < 1 || val > 255) return false; 
            }catch(NumberFormatException ex){
                return false;
            }
        }   
        
        return true;
    }
    
    private boolean isValidV6(String[] strs, String s) {
        if(s.charAt(s.length()-1) == ':') return false;
        
        for(int i=0; i<8; i++) {
            if(strs[i] == null || strs[i].length() == 0 || strs[i].length() > 4) return false;
            if(i == 0 && strs[i].charAt(0) == '0') return false;
            
            for(int j=0; j<strs[i].length(); j++) {
                if(!Character.isDigit(strs[i].charAt(j)) && !Character.isLetter(strs[i].charAt(j))) return false;
            }    
        }
        
        return true;
    }
}
