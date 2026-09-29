import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class StopWordFilteredWordFrequencyReport {
    static void printFilteredWordFrequency(String feedback) {
        String cleaned = feedback.toLowerCase()
            .replace(".", "")
            .replace(",", "")
            .replace("!", "")
            .replace("?", "")
            .replace(";", "")
            .replace(":", "");

        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};
        HashMap<String, Integer> counts = new HashMap<>();

        for (String word : cleaned.split("\\s+")) {
            if (word.isEmpty()) {
                continue;
            }

            boolean isStopWord = false;

            for (String stopWord : stopWords) {
                if (word.equals(stopWord)) {
                    isStopWord = true;
                    break;
                }
            }

            if (!isStopWord) {
                counts.put(word, counts.getOrDefault(word, 0) + 1);
            }
        }

        ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<>(counts.entrySet());
        entries.sort(Comparator.comparing(Map.Entry<String, Integer>::getValue).reversed());

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

public class f5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String feedback = sc.nextLine();
        StopWordFilteredWordFrequencyReport.printFilteredWordFrequency(feedback);
        sc.close();
    }
}