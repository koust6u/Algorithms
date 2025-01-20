import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String, Integer> dictionary = new HashMap<>();
        int count = Integer.parseInt(st.nextToken());
        int trim = Integer.parseInt(st.nextToken());

        for (int i = 0; i < count; i++) {
            String word = br.readLine();
            if (word.length() >= trim) {
                dictionary.put(word, dictionary.getOrDefault(word, 0) + 1);
            }
        }
        List<Word> list = new ArrayList<>();
        for (Entry<String, Integer> entry : dictionary.entrySet()) {
            list.add(new Word(entry.getKey(), entry.getValue()));
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        list.forEach(e -> sb.append(e).append("\n"));
        System.out.println(sb);
    }

    private static class Word implements Comparable<Word> {
        private final int count;
        private final String word;

        public Word(String word, int count) {
            this.count = count;
            this.word = word;
        }

        @Override
        public int compareTo(Word o) {
            if (count == o.count) {
                if (word.length() == o.word.length()) {
                    return String.CASE_INSENSITIVE_ORDER.compare(word, o.word);
                }
                return -1 * Integer.compare(word.length(), o.word.length());
            }
            return -1 * Integer.compare(count, o.count);
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || getClass() != object.getClass()) {
                return false;
            }
            Word word1 = (Word) object;
            return count == word1.count && Objects.equals(word, word1.word);
        }

        @Override
        public int hashCode() {
            return Objects.hash(count, word);
        }

        @Override
        public String toString() {
            return word;
        }
    }
}
