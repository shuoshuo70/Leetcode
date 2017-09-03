package LC45;


public class Class1 {
	
	public boolean judgeCircle(String moves) {
        //handle null
        if(moves == null || moves.length() == 0) {
            return true;
        }
        
        //start point
        int x = 0, y = 0;
        
        for(int i=0; i<moves.length(); i++) {
            char c = moves.charAt(i);
            
            if(c == 'L') {
                x -= 1;
            } else if(c == 'R') {
                x += 1;
            } else if(c == 'U') {
                y += 1;
            } else {
                y -= 1;
            }
        }
        
        return x == 0 && y == 0;
    }
}
