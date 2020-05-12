package Q1_01_Is_Unique;

//Algorithm to determine if a string has all unique characters.
public class SolutionA {
	public static boolean isUniqueChars(String str) {
		if (str.length() > 256) {
			return false;
		}
		boolean[] char_set = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val]) return false;
			char_set[val] = true;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String[] words = {"abcde", "pappaya", "xyz", "dawn", "paddle"};
		for (String word : words) {
			System.out.println(word + ": " + isUniqueChars(word));
		}
	}

}
