import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ScrabbleSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the pool of letters:");
        String letters = scanner.nextLine().toUpperCase();

        Map<Integer, List<String>> wordsByLetterCount = new HashMap<>();
        Map<Character, Integer> lettersCountMap = getCharacterCountMap(letters);

        try (BufferedReader reader = new BufferedReader(new FileReader("ScrabbleSolver/Collins Scrabble Words (2019).txt"))) {
            String currentWord;
            while ((currentWord = reader.readLine()) != null) {
                if (canFormWord(currentWord, lettersCountMap)) {
                    int letterCount = currentWord.length();
                    List<String> words = wordsByLetterCount.getOrDefault(letterCount, new ArrayList<>());
                    words.add(currentWord);
                    wordsByLetterCount.put(letterCount, words);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Sort the letter counts in order
        List<Integer> sortedLetterCounts = new ArrayList<>(wordsByLetterCount.keySet());
        sortedLetterCounts.remove(Integer.valueOf(1)); // Remove 1-letter words
        //Collections.sort(sortedLetterCounts, Collections.reverseOrder()); //descending order
        Collections.sort(sortedLetterCounts); //ascending order

        // Print words organized by letter count
        for (int letterCount : sortedLetterCounts) {
            System.out.println("Letter Count: " + letterCount);
            List<String> words = wordsByLetterCount.get(letterCount);
            for (String word : words) {
                System.out.println(word);
            }
            System.out.println();
        }
    }

    private static Map<Character, Integer> getCharacterCountMap(String letters) {
        Map<Character, Integer> lettersCountMap = new HashMap<>();

        for (char c : letters.toCharArray()) {
            int count = lettersCountMap.getOrDefault(c, 0);
            lettersCountMap.put(c, count + 1);
        }

        return lettersCountMap;
    }

    private static boolean canFormWord(String word, Map<Character, Integer> lettersCountMap) {
        Map<Character, Integer> wordCountMap = new HashMap<>(lettersCountMap);

        for (char c : word.toCharArray()) {
            if (wordCountMap.containsKey(c)) {
                int count = wordCountMap.get(c);
                if (count > 0) {
                    wordCountMap.put(c, count - 1);
                } else {
                    return false;
                }
            } else if (wordCountMap.containsKey('_')) {
                int count = wordCountMap.get('_');
                if (count > 0) {
                    wordCountMap.put('_', count - 1);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
