package LessonThree;

import java.util.HashSet;
import java.util.Objects;

public class SomeWord {
    private String word;

    public SomeWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SomeWord someWord = (SomeWord) o;
        return Objects.equals(word, someWord.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }

    @Override
    public String toString() {
        return word;
    }

}
