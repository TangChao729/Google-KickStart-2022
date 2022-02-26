import java.util.*;

public class Solution {

  private static String getRuler(String kingdom) {
    // TODO: implement this method to determine the ruler name, given the kingdom.
	ArrayList<Character> vowels = new ArrayList<>(Arrays.asList('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'));
	
	int lengthOfKingdomName = kingdom.length();
	
	StringBuilder sb = new StringBuilder(kingdom);
	
	char lastLetter = sb.charAt(lengthOfKingdomName - 1);
	
	if (lastLetter == 'y' || lastLetter == 'Y') {
		return "nobody";
	}
	
	if (vowels.indexOf(lastLetter) == -1) {
		return "Bob"; // 1 == Bob
	}
	
	return "Alice"; // -1 = Alice

  }

  public static void main(String[] args) {
    try (Scanner in = new Scanner(System.in)) {
      int T = in.nextInt();

      for (int t = 1; t <= T; ++t) {
        String kingdom = in.next();
        
        System.out.println(
            "Case #" + t + ": " + kingdom + " is ruled by " + getRuler(kingdom) + ".");
      }
    }
  }
}
