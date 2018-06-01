import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.Scanner;

// (Counting Duplicate Words) Write a program that determines and prints
// the number of duplicate words in a sentence. Treat uppercase and
// lowercase letters the same. Ignore punctuation.

public class CountingDuplicateWords {
    public static void main(String[] args) {
        Map<String, Integer> myMap = new HashMap<>();
        createMap(myMap);
        displayMap(myMap);
    }

    // create map from user input
    private static void createMap(Map<String, Integer> map) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = scanner.nextLine();

        // tokenize the input
        String[] tokens = input.split(" ");

        // processing input text
        for (String token : tokens) {
            String word = token.toLowerCase(); // get lowercase word
            // if the map contains the word
            if (map.containsKey(word)) {
                int count = map.get(word); // get current count
                map.put(word, count + 1); // increment count
            } else {
                map.put(word, 1); // add new word with a count of 1 to map
            }
        }
    }

    // display map content
    private static void displayMap(Map<String, Integer> map) {
        Set<String> keys = map.keySet(); // get keys
        // sort keys
        TreeSet<String> sortedKeys = new TreeSet<>(keys);
        System.out.printf("%nMap contains:%nKey\t\tValue%n");
        // generate output for each key in map
        for (String key : sortedKeys) {
            if (map.get(key) < 2) {
                map.remove(key);
            } else {
                System.out.printf("%-10s%10s%n", key, map.get(key));
            }
        }

        int sum = 0;
        for (int value : map.values()) {
            sum += value;
        }
        System.out.printf("Total duplicate words = " + sum);
        System.out.printf("%nsize: %d%nisEmpty: %b%n", map.size(), map.isEmpty());
    }
}
