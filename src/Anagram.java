
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagram {
    
    public static void main(String[] args) {
        String word1 = "silent";
        String word2 = "sten";
        System.out.println(isAnagram(word1, word2));

        String word3 = "cows";
        List<String> anagramList = possibleAnagrams(word3);
        System.out.println(anagramList);
        System.out.println(anagramList.size());// the size is always the (wordlength)! say 4! = 24
    }
        
    private static boolean isAnagram(String word1, String word2) {
        String word1Ordered = orderAsc(word1);
        String word2Ordered = orderAsc(word2);
        return word1Ordered.equals(word2Ordered);
    }
    private static String orderAsc(String word){

    char[] chars = word.toCharArray();
    char temp;
    for(int i=0; i < chars.length; i++) {
        for(int j=i+1; j < chars.length; j++) {
            if(chars[j] > chars[i]) {
               temp = chars[i];
               chars[i] = chars[j];
               chars[j] = temp;
            }
         }
      }
    
      return Arrays.toString(chars);
    }

    //various permutations that could be formed from a word
    //create a hashmap to store already computed permuations
    private static Map<String, List<String>> memo = new HashMap<>();
    private static List<String> possibleAnagramsWithMemoization(String word){
        //check if the map containss the permutations
        if(memo.containsKey(word)){
            return memo.get(word);
        }
        //base case, when the string is empty
        if(word.isEmpty()){
            List<String> baseResult = new ArrayList<>();
            baseResult.add("");
            return baseResult;
        }
        //create a list to store the anagrams
        List<String> anagramList = new ArrayList<>();
        // Recursive case: for each character, fix it as the first character
        // and find all anagrams of the remaining characters
        for (int i = 0; i < word.length(); i++) {
            char currentCharacter = word.charAt(i);
            //remaining characters
            String remainingChars = word.substring(0, i) + word.substring(i+1);

            //find the list of anagrams for the remaining chars
            List<String> remainingCharsAnagram = possibleAnagrams(remainingChars);

            //append the anagrams to the first/current character
            for(String anagram : remainingCharsAnagram){
                anagramList.add(currentCharacter + anagram);
            } 
        }
        memo.put(word, anagramList);
        return anagramList;
    }


    private static List<String> possibleAnagrams(String word){
        //base case, when the string is empty
        if(word.isEmpty()){
            List<String> baseResult = new ArrayList<>();
            baseResult.add("");
            return baseResult;
        }
        //create a list to store the anagrams
        List<String> anagramList = new ArrayList<>();
        // Recursive case: for each character, fix it as the first character
        // and find all anagrams of the remaining characters
        for (int i = 0; i < word.length(); i++) {
            char currentCharacter = word.charAt(i);
            //remaining characters
            String remainingChars = word.substring(0, i) + word.substring(i+1);

            //find the list of anagrams for the remaining chars
            List<String> remainingCharsAnagram = possibleAnagrams(remainingChars);

            //append the anagrams to the first/current character
            for(String anagram : remainingCharsAnagram){
                anagramList.add(currentCharacter + anagram);
            } 
        }

        return anagramList;
    }
            /*
            * For input "abc":

            First level:

            Choose 'a', remaining string is "bc".
            Choose 'b', remaining string is "ac".
            Choose 'c', remaining string is "ab".
            Second level for each recursive choice:

            For "bc":
            Choose 'b', remaining is "c" → Result: "bc".
            Choose 'c', remaining is "b" → Result: "cb".
            Combining with 'a' from the first level gives "abc" and "acb".
            Continue similarly for other choices
            */

}
