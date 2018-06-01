import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.Scanner;

//(Counting Letters)count the number of occurrences of each letter rather than
// of each word.For example, the string "HELLO THERE" contains two Hs, three Es,
// two Ls, one O, one T and one R. Display the results.

public class CountingLetters {
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
        String[] tokens = input.replaceAll("[^a-zA-Z]", "").split("");

        // processing input text
        for (String token : tokens) {
            String letter = token.toLowerCase(); // get lowercase letter
            // if the map contains the letter
            if (map.containsKey(letter)) {
                int count = map.get(letter); // get current count
                map.put(letter, count + 1); // increment count
            } else {
                map.put(letter, 1); // add new letter with a count of 1 to map
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
        for (String key : sortedKeys)
            System.out.printf("%-10s%10s%n", key, map.get(key));
        System.out.printf("%nsize: %d%nisEmpty: %b%n", map.size(), map.isEmpty());
    }
}
