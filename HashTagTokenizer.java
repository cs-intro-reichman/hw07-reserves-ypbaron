

public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);
		for (int i = 0; i < dictionary.length; i++){
			String word = in.readLine();
			dictionary [i] = word;
		}
		return dictionary;
	}

	public static boolean existInDictionary(String word, String []dictionary) {
		for (int i = 0; i < dictionary.length ; i++){
			if (word.equals(dictionary[i])){
				return true;
			}	
		}
		return false;
	}


	public static void breakHashTag(String hashtag, String[] dictionary) {
		String lowercaseH = hashtag.toLowerCase(); // lowerases all the letters
		// Base case: do nothing (return) if hashtag is an empty string.
        if (lowercaseH.isEmpty()) {
            return ;
        }
 
        int N = lowercaseH.length();

        for (int i = 1; i < N ; i++) {
			boolean isExist = existInDictionary(lowercaseH.substring(0, i), dictionary);
			if (isExist) {
				System.out.println(lowercaseH.substring(0, i));
				breakHashTag(lowercaseH.substring(i), dictionary);
			}
        }
		return;
    }

}
