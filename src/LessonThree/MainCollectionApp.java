package LessonThree;

public class MainCollectionApp {
    public static void main(String[] args) {
        ListOfWord word = new ListOfWord();
        word.printList(word.getSomeWords());
        System.out.println("List of Unique");
        word.printList(word.getUniqueWordList());
        word.countingDuplicateWords(word.getUniqueWordList());
    }
}
