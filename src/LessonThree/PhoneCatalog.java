package LessonThree;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class PhoneCatalog {
    private HashMap<String, List<Integer>> phoneCat;

    public PhoneCatalog(HashMap<String, List<Integer>> phoneCat) {
        this.phoneCat = phoneCat;
    }

    public PhoneCatalog() {
        phoneCat = new HashMap<>();
    }

    public void addNewPhoneNumber(String name, Integer number) {
        if (phoneCat.containsKey(name)) {
            phoneCat.get(name).add(number);
            return;
        }
        List<Integer> numbers = new ArrayList<>();
        numbers.add(number);
        phoneCat.put(name, numbers);
    }

    public List<Integer> getNumber(String name) {
        return phoneCat.get(name);
    }

    public void printPhones(String name) {
        List<Integer> numbers = getNumber(name);
        StringBuilder builder = new StringBuilder();
        builder.append("Number for name: ");
        builder.append(name);
        builder.append("\n");
        for (Integer num: numbers
             ) {
            builder.append(num).append("\n");
        }
        System.out.println(builder.toString());
    }




}
