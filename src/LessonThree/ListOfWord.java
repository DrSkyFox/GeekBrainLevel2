package LessonThree;

import java.util.*;

public class ListOfWord {

    private List<SomeWord> someWords;

    public ListOfWord(int wordsCount, int maxLengthWord) {
        generateRandomWords(wordsCount, maxLengthWord);
    }

    public ListOfWord(int wordsCount) {
        generateRandomWords(wordsCount, 10);
    }


    public ListOfWord(List<SomeWord> someWords) {
        this.someWords = someWords;
    }

    private void generateRandomWords(int wordsCount, int maxLengthOfWord) {
        someWords = new ArrayList<>();
        Random random = new Random();
        int m = 0;
        for (int i = 0; i < wordsCount; i++) {
            m = random.nextInt(20);
            if(m == 0) {
                someWords.add(new SomeWord("RedCow"));
            } else if(m == 1) {
                someWords.add(new SomeWord("SomeBody"));
            } else if(m== 2) {
                someWords.add(new SomeWord("Re: Zero kara Hajimeru Isekai Seikatsu"));
            } else if(m ==3) {
                someWords.add(new SomeWord("DarkSouls"));
            } else {
                someWords.add(new SomeWord(genWord(random.nextInt(maxLengthOfWord) + 3)));
            }
        }
    }

    public HashSet<SomeWord> getUniqueWordList() {
        HashSet<SomeWord> someWordsUniq = new HashSet<>();
        for (SomeWord word: someWords
             ) {
            someWordsUniq.add(word);
        }
        return someWordsUniq;
    }

    public void countingDuplicateWords(HashSet<SomeWord> collections) {
        for (SomeWord word: collections
        ) {
            System.out.println(
                    new StringBuilder().append("Word is \"")
                    .append(word).append("\" counting: ")
                    .append(Collections.frequency(someWords, word))
                    .toString()
            );
        }
    }

    public List<SomeWord> getSomeWords() {
        return someWords;
    }

    public void setSomeWords(List<SomeWord> someWords) {
        this.someWords = someWords;
    }

    public ListOfWord() {
        generateRandomWords(50, 10);
    }

    private String genWord(int length) {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            builder.append((char)('a' + random.nextInt(26)));
        }
        return builder.toString();
    }

    public void printList(Collection someWordsList) {
        for (Object word: someWordsList
             ) {
            System.out.println(word.toString());
        }
    }


    @Override
    public String toString() {
        return "ListOfWord{" +
                "someWords=" + someWords +
                '}';
    }

}
