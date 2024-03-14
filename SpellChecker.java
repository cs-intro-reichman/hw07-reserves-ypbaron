
public class SpellChecker {


	public static void main(String[] args) {
		// String word = args[0]; // "hello";
		// String word1 = "concensus";
		// String word2 = "consensus";

		// System.out.println(levenshtein(word1, word2));

		// int threshold = Integer.parseInt(args[1]);// 2; //
		// String[] dictionary = readDictionary("dictionary.txt");
		// String correction = spellChecker(word, threshold, dictionary);
		// System.out.println(correction);
	}

	public static String tail(String str) {
		if (str.length() == 0) {
			return "";// Your code goes here
		}
		return str.substring(1);// Your code goes here
	}

	public static int levenshtein(String word1, String word2) {
		// Your code goes here
		word1.toLowerCase();
		word2.toLowerCase();
		String tail1 = tail(word1);// calls tails
		String tail2 = tail(word2);// calls tails

		if (word2.length() == 0) {
			return word1.length();
		} else if (word1.length() == 0) {
			return word2.length();
		} else if (word1.charAt(0) == word2.charAt(0)) {
			return levenshtein(tail1, tail2);
		}
		return 1 + Math.min(Math.min(levenshtein(tail1, word2), levenshtein(word1, tail2)), levenshtein(tail1, tail2));
	}		
		

	
	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);

		// Your code here
		for (int i = 1; i < dictionary.length; i++){
			String word = in.readLine();
			dictionary [i] = word;
		}
		return dictionary;
	}


	public static String spellChecker(String word, int threshold, String[] dictionary) {
		// Your code goes here
		int minDistance = levenshtein(word, dictionary[0]); // a temporary placment
		String closeWord = dictionary[0];

		for (int i = 0; i < dictionary.length ; i++){
			int newDistance = levenshtein(word, dictionary[i]);

			if(newDistance < minDistance) {
				minDistance = newDistance; // finding the minumum distance
				closeWord = dictionary[i]; // brings the closest word to correct

			}
		}
		if (minDistance <= threshold)
			return closeWord;
			return word;
	}
}

