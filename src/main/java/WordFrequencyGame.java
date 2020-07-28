import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyGame {
    public String getResult(String sentence) {

        Map<String, Integer> wordMap = calculateFrequentWords(sentence);

        List<Input> list = getWordCounts(wordMap);

        sort(list);

        StringJoiner joiner = formatSentence(list);
        return joiner.toString();
    }

    private void sort(List<Input> list) {
        list.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());
    }

    private List<Input> getWordCounts(Map<String, Integer> wordMap) {
        List<Input> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            Input input = new Input(entry.getKey(), entry.getValue());
            list.add(input);
        }
        return list;
    }

    private StringJoiner formatSentence(List<Input> inputList) {
        StringJoiner joiner = new StringJoiner("\n");
        for (Input w : inputList) {
            String s = w.getValue() + " " + w.getWordCount();
            joiner.add(s);
        }
        return joiner;
    }

    private Map<String, Integer> calculateFrequentWords(String sentence) {
        return Arrays.stream(sentence.split("\\s+"))
                .collect(Collectors.toMap(num -> num,num -> 1, Integer::sum));
    }
}
