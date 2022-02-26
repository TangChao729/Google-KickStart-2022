import java.util.*;

public class Solution {

  public static int[] getHIndexScore(int[] citationsPerPaper) {
    int[] hIndex = new int[citationsPerPaper.length];

    // TODO: Add logic to calculate h-index score for each paper
    
	ArrayList<Integer> currGroup = new ArrayList<Integer>();
	int currMax = 1;
	
	int currHScore = 0;
    
    for (int i=0; i<citationsPerPaper.length; i++) {

    	currGroup.add(citationsPerPaper[i]);
    	
    	int numOfMax = 0;
    	for (int j=0; j<currGroup.size(); j++) {
    		
    		if (currGroup.get(j) >= currMax) {
    			numOfMax += 1;
    		}
    	}

    	
    	
    	
    	if (numOfMax < currMax) {
    		
    		currHScore = numOfMax;
    	}
    	else {
    		currHScore = currMax;
    	}
    	
    	hIndex[i] = currHScore;
    	
    	System.out.println(currGroup);
    	System.out.println(currMax);
    	System.out.println(numOfMax);
    	System.out.println(currHScore);
    	
    	
    	currMax = currHScore + 1;
    	
    }    
    return hIndex;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // Get number of test cases in input
    int testCaseCount = scanner.nextInt();
    // Iterate through test cases
    for (int tc = 1; tc <= testCaseCount; ++tc) {
      // Get number of papers for this test case
      int paperCount = scanner.nextInt();
      // Get number of citations for each paper
      int[] citations = new int[paperCount];
      for (int p = 0; p < paperCount; ++p) {
        citations[p] = scanner.nextInt();
      }
      // Print h-index score after each paper in this test case
      System.out.print("Case #" + tc + ":");
      for (int score : getHIndexScore(citations)) {
        System.out.append(" ").print(score);
      }
      System.out.println();
    }
  }
}
