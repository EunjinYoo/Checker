
public class Checker {
    public static void main(String args[]) {
        Piece[][] checker = new Piece[8][8];
        int[] axis = {0, 1, 2, 3, 4, 5, 6, 7};
        
        // making empty checkerboard
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                checker[i][j] = new Piece();
            }
        }
        // made empty checkerboard
        
        
        // board setting
        int a = 1;
        int b = 0;
        while(a<8){
            checker[0][a].number = 1;
            checker[1][b].number = 1;
            checker[2][a].number = 1;
            
            checker[5][b].number = 2;
            checker[6][a].number = 2;
            checker[7][b].number = 2;
            a=a+2;
            b=b+2;
        }
        // board set
        
        
        // gameplay
        boolean isPlaying = true;
        int pl = 2;
        while(isPlaying == true){
        	
        	// print checker board
        	System.out.print("   ");
        	for(int ax : axis) {
        		System.out.print(ax+" ");
        	}
        	System.out.println("	<- X axis\n +-----------------+");
        	
        	int yax = 0;
            for(Piece[] i : checker){
            	System.out.print(yax+"| ");
            	yax++;
            	
                for(Piece j : i){
                    if(j.number==0){
                        System.out.print("  ");
                    } else {
                        System.out.print(j.number+" ");
                    }
                }
                System.out.println("");
            }
            System.out.println(" +-----------------+");
            // checker board printed
            
            // player changing
            if(pl == 2) {
            	pl = 1;
            } else {
            	pl = 2;
            }
            
            // starting message
            System.out.println("Turn of player no." + pl);
            System.out.println("Coordinate of piece to move");
            
            // choose piece to move
            String currentPosition = GameHelper.coordinatePiece();
            while(currentPosition == "Wrong input. Please enter an integer.") {
            	System.out.println(currentPosition);
            	currentPosition = GameHelper.coordinatePiece();
            }
            String currentPosition0 = currentPosition.substring(0,1);
            String currentPosition2 = currentPosition.substring(2);
            int currentx = Integer.parseInt(currentPosition0);
            int currenty = Integer.parseInt(currentPosition2);
            
            
            // choose new place to move the piece
            int[] nums = new int[2];
            boolean isEmpty = false;
            while(isEmpty == false) {
            	System.out.println("\nCoordinate of new position");
            	
                String newPosition = GameHelper.coordinatePiece();
                
                String newPosition0 = newPosition.substring(0,1);
                String newPosition2 = newPosition.substring(2);
                int newx = Integer.parseInt(newPosition0);
                int newy = Integer.parseInt(newPosition2);
                
                nums[0] = newx;
                nums[1] = newy;
                
                
                // check if the piece can be moved
                isEmpty = GameHelper.moveCheck(pl, currentx, currenty, newx, newy);
                
                if(isEmpty == false) {
                	System.out.println("Wrong input. The piece cannot be moved there.");
                }
            }		// while(isEmpty == false) ends
            
            // move the piece
            int newx = nums[0];
            int newy = nums[1];
            checker[currenty][currentx].number = 0;
            checker[newy][newx].number = pl;
            
        }			// while(isPlaying == true) ends
        
        
        
        
    }
}
