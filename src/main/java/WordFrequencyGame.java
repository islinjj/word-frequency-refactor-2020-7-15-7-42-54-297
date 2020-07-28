import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyGame {
    public String getResult(String sentence) {

        Map<String, Integer> wordMap = calculateFrequentWords(sentence);

        return wordMap
                .entrySet()
                .stream()
                .sorted((e1,e2) -> e2.getValue() - e1.getValue())
                .map(e -> e.getKey() + " " + e.getValue())
                .collect(Collectors.joining("\n"));
    }

    private Map<String, Integer> calculateFrequentWords(String sentence) {
        return Arrays.stream(sentence.split("\\s+"))
                .collect(Collectors.toMap(num -> num,num -> 1, Integer::sum));
    }
}
