import java.util.*;

public class Solution {

	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    // Read the number of test cases.
	    int t = scanner.nextInt();
	    
	    System.out.println("Total board numbers: " + t);
	    
	    for (int caseIndex = 1; caseIndex <= t; caseIndex++) {
	      // Read the board size.
	      int n = scanner.nextInt();
	      
	      System.out.println("Current board grid length: " + n);
	      // Read each row of the board.
	      char[][] board = new char[n][];
	      for (int i = 0; i < n; i++) {
	        board[i] = scanner.next().toCharArray();
	        System.out.println("Scan success");
	      }
	      // Determine the game status and display it.
	      //String status = determineStatus(board);
	      System.out.println("current board number: " + caseIndex);
	      
	      for (int i=0; i<board.length; i++) {
	      	  System.out.println(board[i]);
	      	  }
	     
	      
	      
	      //System.out.println("Board #" + board);
	      //System.out.println("Case #" + caseIndex + ": " + status);
	    }
	    
	    //System.out.println(board[0]);
	    //System.out.println("====next board====");
	}
	
	public static ArrayList<Block> findNeighbours(Block blockInfo) {
		//always start from left to right (if blue), or top to bottom (if red)
		if (blockInfo.getColor().equals("blue")) {  //search from left to right
			
		}
		
		else { 										//search from left to right
			
		}
	}
	
	  /** Returns a status string as specified by the Hex problem statement. */
	public static String determineStatus(char[][] board) {
	    // TODO(you): Implement this method to solve the problem!
	    return "";
	}
	  
	  
}

class Block {
	
	private String myColor;
	
	private ArrayList<Integer> myPosition;
	
	private HashMap<String, ArrayList<Integer>> myBlockInfo;
	
	public Block(String color, ArrayList<Integer> position) {
		myColor = color;
		myPosition = position;
		myBlockInfo = new HashMap<String, ArrayList<Integer>>();
		myBlockInfo.put(color, position);
		
	}
	
	public String getColor() {
		return myColor;
	}
	
	public ArrayList<Integer> getPosition() {
		return myPosition;
	}

	public String toString() {
		return "Color: " + myColor + " Position: " + myPosition;
	}
}



