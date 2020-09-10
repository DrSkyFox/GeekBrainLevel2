package lessonFive;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThreadDemoMain {
    public static void main(String[] args) throws NoSuchMethodException {

        float[] arr = new float[100000000];
        List<Long> longs = new ArrayList<>();

        MyArray myArray = new MyArray(2);
        longs.add(myArray.timeOperation(MyArray.class.getMethod("fillArrayOnes", float[].class), arr));

        arr = null;
        arr = new float[100000000];
        longs.add(myArray.timeOperation(MyArray.class.getMethod("fillArrayOnesThread", float[].class), arr));

        arr = null;
        arr = new float[100000000];
        longs.add(myArray.timeOperation(MyArray.class.getMethod("fillArrayWithMath", float[].class), arr));

        arr = null;
        arr = new float[100000000];
        longs.add(myArray.timeOperation(MyArray.class.getMethod("fillArrayWithMathThreads", float[].class), arr));


        for (Long aLong :
                longs) {
            System.out.println("Result of runnings: " + aLong);
        }




    }

    private static void checker(float[] arr) {
        boolean check = true;
        for (float a:
                arr) {
            if(a != 1.0f) {
                check = false;
            }
        }
        System.out.println(check);
    }




}
