package LessonThree;

public class MainCollectionApp {
    public static void main(String[] args) {
        collectionTask();

        phoneTask();
    }

    private static void collectionTask() {
        ListOfWord word = new ListOfWord();
        word.printList(word.getSomeWords());
        System.out.println("List of Unique");
        word.printList(word.getUniqueWordList());
        word.countingDuplicateWords(word.getUniqueWordList());
    }

    private static void phoneTask() {
        PhoneCatalog phoneCatalog = new PhoneCatalog();
        phoneCatalog.addNewPhoneNumber("Rose", 755567);
        phoneCatalog.addNewPhoneNumber("Joker", 45674135);
        phoneCatalog.addNewPhoneNumber("Batman", 911);
        phoneCatalog.addNewPhoneNumber("Rose", 123456);
        phoneCatalog.addNewPhoneNumber("Robin", 41842398);
        phoneCatalog.addNewPhoneNumber("Batman", 112);
        phoneCatalog.printPhones("Rose");
    }

}
