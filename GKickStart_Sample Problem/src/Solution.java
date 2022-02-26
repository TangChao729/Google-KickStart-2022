import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // T equal to N test cases

		
		for (int j = 0; j<t; j++) {
			
			
			int numBags = in.nextInt(); // numBags = number of bags
			
			int numKids = in.nextInt(); // similar to above
			
			int totalNumBags = 0;
			for (int i=0; i<numBags; i++) {
				totalNumBags += in.nextInt();
				//System.out.println("Case #" + (j+1) + ": " + "NumBags is: " + numBags);
			
			}

			int leftOver = totalNumBags % numKids;
			
			
			System.out.println("Case #" + (j+1) + ": " + leftOver);
		}
	}
}
