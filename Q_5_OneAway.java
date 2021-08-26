
public class Q_5_OneAway {
	
	public static boolean oneAway(String s1, String s2) {
		
		// Case where lengths make them impossible to be one away
		if (s1.length() < s2.length() - 1 || s1.length() > s2.length() + 1) {
			return false;
		}
		
		String shorter, longer;
		int numMismatches = 0, shorterIndex = 0, longerIndex = 0;
		boolean sameLength = s1.length() == s2.length();
		
		// If there is a length difference, assign the shorter string to 'shorter' variable.
		// Otherwise it doesn't matter.
		shorter = s2.length() < s1.length() ? s2 : s1;
		longer = s2.length() < s1.length() ? s1 : s2;
		
		// Iterate thru both strings and compare each one. If there is one mismatch when comparing different-length strings,
		// decrement the shorter index to essentially "skip" that mismatched character in the longer string,
		// and re-check that char in the shorter string on the next iteration.
		// If there is more than one mismatch, break.
		while (numMismatches <= 1 && shorterIndex < shorter.length()) {
			if (shorter.charAt(shorterIndex) != longer.charAt(longerIndex)) {
				if (!sameLength) {
					shorterIndex--;			
				}
				numMismatches++;
			}
			longerIndex++;
			shorterIndex++;
		}
		
		if (numMismatches <= 1) {
			return true;
		}
		return false;

	}
}
