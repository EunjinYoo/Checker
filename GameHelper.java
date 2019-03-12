import java.util.InputMismatchException;
import java.util.Scanner;

public class GameHelper {
	// choose coordination
    public static String coordinatePiece() {
    	Scanner sc = new Scanner(System.in);
    	String result;
    	while(true) {
    		try {
        		System.out.print("  Enter X: ");
        		int x = sc.nextInt();
        		System.out.print("  Enter Y: ");
                int y = sc.nextInt();
                result = x + " " + y;
                return result;
        	} catch(InputMismatchException | NumberFormatException e) {
        		return "Wrong input. Please enter an integer.";
        	}
    	}
}		// coordinatePiece ends
    
    
    
    
    
 // check if the piece can be moved
    static boolean moveCheck(int playernumber, int currentx, int currenty, int newx, int newy){
		boolean result = false;
		if(playernumber == 1) {
			if(newy-currenty != 1) {
				return false;
			}	//if(newy-currenty!=1) ends
			
		}	// if(playernumber==1) ends
		else {
			if(currenty - newy != 1) {
				return false;
			}	// if(currenty - newy !=1) ends
		}	// else ends
		
		if(newx-currentx==1 || newx-currentx==-1) {
			result = true;
		} else {
			return false;
		}
		
		return result;
	}		// movecheck ends
    
    

    }
