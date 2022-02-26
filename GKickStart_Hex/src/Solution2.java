import java.util.*;

/** Starter code for the Kick Start 2022 problem Hex. */
public class Solution2 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // Read the number of test cases.
    int t = scanner.nextInt();
    for (int caseIndex = 1; caseIndex <= t; caseIndex++) {
      // Read the board size.
      int n = scanner.nextInt();
      // Read each row of the board.
      char[][] board = new char[n][];
      for (int i = 0; i < n; i++) {
        board[i] = scanner.next().toCharArray();
      }
      // Determine the game status and display it.
      String status = determineStatus(board);
      System.out.println("Case #" + caseIndex + ": " + status);
    }
  }

  /** Returns a status string as specified by the Hex problem statement. */
  static String determineStatus(char[][] board) {
    // TODO(you): Implement this method to solve the problem!
	
	  //find Red block's path from top to bottom
	  //always start from row 1 (i=0, j=0, 1, 2
	  
	  for (int j=0; j < board[0].length; j++) {
		  //Starting from board[0][0] to board[0][j]
		  ArrayList<Integer> currPosition = new ArrayList<Integer>();
		  currPosition.add(0);
		  currPosition.add(j);
		  
		  //represent the first neighbour set of starting block, in this case board[0][0]
		  ArrayList<ArrayList<Integer>> newNeighbours = findNeighbours(board, currPosition);
		  
		  //new variable represent all found neighbours
		  ArrayList<ArrayList<Integer>> currNeighbours = new ArrayList<ArrayList<Integer>>();
		  
		  //maximum times to find neighbour = total board sizes
		  int maxTimes = board[0].length * board[1].length;
		  
		  //add new found neighbour to found set
		  for (int index = 0; index < newNeighbours.size(); index++) {
			  currNeighbours.add(newNeighbours.get(index));
		  }
		  
		  boolean ender = false;
		  while (ender != true) {
			  for (int k=0; k<currNeighbours.size(); k++) { //starting from first neighbour set
				  newNeighbours = findNeighbours(board, currNeighbours.get(k)); //for neighbours for each neighbours
				  for (int p=0; p<newNeighbours.size(); p++) { //check each new found neighbour
					  if (currNeighbours.indexOf(newNeighbours.get(p)) == -1) { //if cannot find in currNeighbour set
						  currNeighbours.add(newNeighbours.get(p)); //add to currNeighbour set
					  }
				  }
			  }
			  
		  }
		  
		  
		  
	  }
	  
	  /////////////////////////////////////////////
	  for (int i=0; i < board.length; i++) {
		
		for (int j=0; j < board[i].length; j++) {
			
			char color = board[i][j];
			int row = i;
			int column = j;
			
			System.out.println("Color: " + color + " row number: " + row + " column number: " + column);
		}
	}
		
			
	  return "";
  }
  
  public static ArrayList<ArrayList<Integer>> findNeighbours(char[][] board, 
		  											  ArrayList<Integer> currPosition) {
	  ArrayList<Integer> singleNeighbourPos = new ArrayList<Integer>();
	  HashMap<Character,  ArrayList<Integer>> singleNeighbourInfo = new HashMap<Character,  ArrayList<Integer>>();
	  ArrayList<ArrayList<Integer>> totalNeighboursPoses = new ArrayList<ArrayList<Integer>>();
	  
	  //Sample position ArrayList: (1, 1) (row, column)
	  //Neighbours: 
	  //       (0, 1) (0, 2)
	  //(1, 0) (self) (1, 2)
	  //(2, 0) (2, 1) 
	  int gridSize = board.length;
	  int currRow = currPosition.get(0);
	  int currCol = currPosition.get(1);
	  char currColor = board[currRow][currCol];
	  char neighbourColor = ' ';
	  //six neighbours:
	  
	  for (int i=0; i < 3; i++) {
		  if (i==0) { //-1 row
			  singleNeighbourPos.add(currRow - 1); //(0, 1)
			  singleNeighbourPos.add(currCol);
			  totalNeighboursPoses.add(singleNeighbourPos);
			  singleNeighbourPos.clear();
			  
			  singleNeighbourPos.add(currRow - 1); //(0, 2)
			  singleNeighbourPos.add(currCol + 1); 
			  totalNeighboursPoses.add(singleNeighbourPos);
			  singleNeighbourPos.clear();
		  }
		  
		  if (i==1) { //same row
			  singleNeighbourPos.add(currRow); //(1, 0)
			  singleNeighbourPos.add(currCol - 1);
			  totalNeighboursPoses.add(singleNeighbourPos);
			  singleNeighbourPos.clear();
			  
			  singleNeighbourPos.add(currRow); //(1, 2)
			  singleNeighbourPos.add(currCol + 1); 
			  totalNeighboursPoses.add(singleNeighbourPos);
			  singleNeighbourPos.clear();
		  }
		  
		  if (i==2) { //+1 row
			  singleNeighbourPos.add(currRow + 1); //(2, 0)
			  singleNeighbourPos.add(currCol - 1);
			  totalNeighboursPoses.add(singleNeighbourPos);
			  singleNeighbourPos.clear();
			  
			  singleNeighbourPos.add(currRow + 1); //(2, 1)
			  singleNeighbourPos.add(currCol);
			  totalNeighboursPoses.add(singleNeighbourPos);
			  singleNeighbourPos.clear();
		  }
		  
	  }
	  
	  //remove illegal neighbours
	  
	  ArrayList<ArrayList<Integer>> neighboursToRemove = new ArrayList<ArrayList<Integer>>();
	  
	  for (int i=0; i < totalNeighboursPoses.size(); i++) {
		  if (totalNeighboursPoses.get(i).get(0) < 0 || totalNeighboursPoses.get(i).get(0) > gridSize) {
			  neighboursToRemove.add(totalNeighboursPoses.get(i));
		  }
		  if (totalNeighboursPoses.get(i).get(1) < 0 || totalNeighboursPoses.get(i).get(1) > gridSize) {
			  neighboursToRemove.add(totalNeighboursPoses.get(i));
		  }
	  }
	  
	  for (int i=0; i < neighboursToRemove.size(); i++) {
		  totalNeighboursPoses.remove(neighboursToRemove.get(i));
	  }
	  
	  //assign color to each neighbour -- no need to, just filter neighbours with matching color
	  
	  //each neighbour's info is a HashMap: Color, <Position>
	  //HashMap<Character, ArrayList<Integer>> neighbourInfoWithColor = new HashMap<Character, ArrayList<Integer>>();
	  //total neighbours' info is a arraylist of neighbour's info
	  //ArrayList<HashMap<Character, ArrayList<Integer>>> totalNeighboursInfo = new ArrayList<HashMap<Character, ArrayList<Integer>>>;
	  
	  for (int i=0; i < totalNeighboursPoses.size(); i++) {
		  neighbourColor = board[totalNeighboursPoses.get(i).get(0)] [totalNeighboursPoses.get(i).get(1)]; //get the color
		  if (neighbourColor != currColor) { //now find correct neighbours based on the color
			  totalNeighboursPoses.remove(totalNeighboursPoses.get(i)); //form hashmap
		  }
	  }
	  return totalNeighboursPoses;
  }
}
