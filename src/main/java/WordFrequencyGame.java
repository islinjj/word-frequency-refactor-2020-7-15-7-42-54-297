import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class WordFrequencyGame {
    public String getResult(String sentence) {

        Map<String, Integer> wordMap = calculateFrequentWords(sentence);

        List<Input> list = getWordCounts(wordMap);

        list.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());

        StringJoiner joiner = formatSentence(list);
        return joiner.toString();
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
        Map<String, Integer> wordsMap = new HashMap<>();
        String[] words = sentence.split("\\s+");
        for (String word:words) {
            if (wordsMap.containsKey(word)){
                wordsMap.put(word,wordsMap.get(word)+1);
            } else {
                wordsMap.put(word,1);
            }
        }
        return wordsMap;
    }
}
