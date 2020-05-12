package Q1_04_Palindrome_Permutation;

//Given a string, write a function to check if its a permutation of palindrome. A palindrome is a word or phrase that is same forwards and backwards,
//A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
public class SolutionA {
	public static boolean checkMaxOneOdd(int[] table) {
		boolean foundOdd = false;
		for (int count : table) {
			if (count % 2 == 1) {
				if (foundOdd) {
					return false;
				}
				foundOdd = true;
			}
		}
		return true;
	}
	
	public static boolean isPermutationOfPalindrome(String phrase) {
		int[] table = Common.buildCharFrequencyTable(phrase);
		return checkMaxOneOdd(table);
	}
	
	public static void main(String[] args) {
		String pali = "Rats live on no evil star trek krte";
		System.out.println(isPermutationOfPalindrome(pali));
	}

}
