import java.util.*;

public class Milktea_solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int testCases = in.nextInt();
    for (int testCase = 1; testCase <= testCases; testCase++) {
      int numberOfFriends = in.nextInt();
      int numberOfForibbenTeas = in.nextInt();
      int optionsOffered = in.nextInt();
      int[][] friendsOrders = new int[numberOfFriends][optionsOffered];
      for (int friend = 0; friend < numberOfFriends; friend++) {
        String currentFriendOrder = in.next().trim();
        for (int option = 0; option < optionsOffered; option++) {
          friendsOrders[friend][option] =
              Character.getNumericValue(currentFriendOrder.charAt(option));
        }
      }
      int[][] forbiddenOrders = new int[numberOfForibbenTeas][optionsOffered];
      for (int forbiddenIndex = 0; forbiddenIndex < numberOfForibbenTeas; forbiddenIndex++) {
        String currentForbiddenTeaOrder = in.next().trim();
        for (int option = 0; option < optionsOffered; option++) {
          forbiddenOrders[forbiddenIndex][option] =
              Character.getNumericValue(currentForbiddenTeaOrder.charAt(option));
        }
      }
      int ans = findSmallestNumberOfComplaints(friendsOrders, forbiddenOrders);
      System.out.println("Case #" + testCase + ": " + ans);
    }
  }

  static int findSmallestNumberOfComplaints(int[][] friendsOrders, int[][] forbiddenOrders) {
    // TODO: implement this method to find the smallest number of complaints given that Shakti will
    // only be getting 1 type of tea for his friends.
    int smallestNumberOfComplaints = -1;
    
    //Step 1: find all possible combinations:
    //shop offer P options, P = order.length
    
    
    int[][] allCombinations = {{0, 0, 0, 0}, //4C0 = 1
    				           {0, 0, 0, 1},{0, 0, 1, 0},{0, 1, 0, 0},{1, 0, 0, 0}, //4C1 = 4
    						   {0, 0, 1, 1},{0, 1, 1, 0},{1, 1, 0, 0},{0, 1, 0, 1},{1, 0, 0, 1},{1, 0, 1, 0}, //4C2 = 6
    						   {0, 1, 1, 1},{1, 1, 1, 0},{1, 0, 1, 1},{1, 1, 0, 1}, //4C3 = 4
    						   {1, 1, 1, 1}}; //4C4 = 1
    
    List<int[]> allComb = new LinkedList<int[]>(Arrays.asList(allCombinations));
    ArrayList<int[]> toRemove = new ArrayList<int[]>();
    
    
    //check forbidden orders
    String forbiddenToString = "";
	for (int i=0; i < forbiddenOrders.length; i++) {
		forbiddenToString = Arrays.toString(forbiddenOrders[i]);
		System.out.println("forbiddenOrders: " + forbiddenToString);
	}
    
	// find repeated forbidden orders from all combinations, add to a toRemove list
    for (int i=0; i < forbiddenOrders.length; i++) {
    	for (int j=0; j < allComb.size(); j++) {
    		if (Arrays.equals(allComb.get(j), forbiddenOrders[i])) {
    			toRemove.add(allComb.get(j));
    		}
    	}
    }
    
    String toRemoveToString = "";
	for (int i=0; i < toRemove.size(); i++) {
		toRemoveToString = Arrays.toString(toRemove.get(i));
		System.out.println("Combinations to remove: " + toRemoveToString);
	}

	
	// for each combination in toRemove list, remove it from all combinations
    for (int i=0; i < toRemove.size(); i++) {
    	
    	allComb.remove(toRemove.get(i));
    }
    
    
    //for each combination, calculate its complaints score, add to score arraylist
    ArrayList<Integer> complaintsArray = new ArrayList<Integer>();
    
    for (int i=0; i < allComb.size(); i++) {
    	int complaints = calComplaintsScore(allComb.get(i), friendsOrders);
    	complaintsArray.add(complaints);
    }
    
    
    //sort arraylist from small to big
    Collections.sort(complaintsArray);
    
    //find the smallest one
    smallestNumberOfComplaints = complaintsArray.get(0);
    
    return smallestNumberOfComplaints;	    
    }

    

  static int calComplaintsScore(int[] currCombination, int[][] friendsOrders) {
	 int complaints = 0;
	 for (int i=0; i < friendsOrders.length; i++) {
		 //System.out.println("friendsOrders length: " + friendsOrders.length);
		 for (int j=0; j < friendsOrders[i].length; j++) {
			 //System.out.println("friendsOrders[i].length: " + friendsOrders[i].length);
			  if (friendsOrders[i][j] != currCombination[j]) {
				  complaints += 1;
			  }
		  }
	 }
	 
	 String currCombToString = "";
	 for (int i=0; i < currCombination.length; i++) {
		 currCombToString += currCombination[i] + " ";
	 }
	//System.out.println("For order: " + currCombToString + " the complaints is: " + complaints);
	return complaints;  
  }
    
}

//Sample simple input
/*
1
3 1 4
1100
1010
0000
1000
*/
//Answer should be 4
