package Q1_02_Check_Permutation;

//Given two Strings, write a method to decide if one is a permutation of other
public class QuestionA {	
	public static String sort(String s) {
		char[] content = s.toCharArray();
		java.util.Arrays.sort(content);
		return new String(content);
	}

	//sort first string and then sort another string and then compare
	public static boolean permutation(String s, String t) {
		if(s.length() != t.length()) return false; // Permutations must be same length
	     return sort(s).equals(sort(t));
	}	
	
	public static void main(String[] args) {
		String[][] pairs = {{"chappal", "pchapal"}, {"dawn", "nawd"}, {"jelly", "yella"},{"abbcd", "abbd"}};
		for (String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			boolean anagram = permutation(word1, word2);
			System.out.println(word1 + ", " + word2 + ": " + anagram);
		}
	}
}
