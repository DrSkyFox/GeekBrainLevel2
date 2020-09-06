package lessonFive;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MyArray {
    private static Logger logger = Logger.getLogger(MyArray.class.getName());
    private int maxCountThreads = 2;


    public int getMaxCountThreads() {
        return maxCountThreads;
    }

    public void setMaxCountThreads(int maxCountThreads) {
        this.maxCountThreads = maxCountThreads;
    }

    public MyArray(int maxCountThreads) {
        this.maxCountThreads = maxCountThreads;
    }

    public void fillArrayOnes(float[] arr, int start, int finish) {
        long time = System.currentTimeMillis();
        for (int i = start; i < finish; i++) {
            arr[i] = 1.0f;
            info(i, 100000);
        }
        logger.info("fillArrayWithMath time:" + (System.currentTimeMillis() - time) + " Thread name:" + Thread.currentThread().getName());
    }

    public void fillArrayOnes(float[] arr) {
        fillArrayOnes(arr, 0, arr.length);
    }

    public void fillArrayWithMath(float[] arr, int start, int finish) {
        long time = System.currentTimeMillis();
        for (int i = start; i < finish; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            info(i, 100000);
        }
        logger.info("fillArrayWithMath time:" + (System.currentTimeMillis() - time) + " Thread name:" + Thread.currentThread().getName());
    }

    public void  fillArrayWithMath(float[] arr) {
        fillArrayWithMath(arr, 0, arr.length);
    }


    public void fillArrayOnesThread(float[] arr,int maxCountThreads) {
        long time = System.currentTimeMillis();
        List<Thread> threadList = new ArrayList<>();
        int step = arr.length/maxCountThreads;
        List<float[]> floats = new ArrayList<>();
        if(arr.length % maxCountThreads == 0) {
            breakdownArray(arr, maxCountThreads, step, floats);
            for (int i = 0; i < maxCountThreads; i++) {
                int current = i;
                threadList.add(threadStart(() -> fillArrayOnes(floats.get(current), 0, step), "Thread["+i+"]"));
            }
        } else {
            System.out.println("SECTION IN PROGRESS... ");
        }
        try {
            for (Thread thread: threadList
                 ) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mergeArray(arr, maxCountThreads, step, floats);
        logger.info("fillArrayOnesThread time:" + (System.currentTimeMillis() - time) + " Thread name:" + Thread.currentThread().getName());
    }


    public void fillArrayWithMathThreads(float[] arr,int maxCountThreads) {
        long time = System.currentTimeMillis();
        List<Thread> threadList = new ArrayList<>();
        int step = arr.length/maxCountThreads;
        List<float[]> floats = new ArrayList<>();
        if(arr.length % maxCountThreads == 0) {

            breakdownArray(arr, maxCountThreads, step, floats);

            for (int i = 0; i < maxCountThreads; i++) {
                int current = i;
                threadList.add(threadStart(() -> fillArrayWithMath(floats.get(current), 0, step),"Thread["+i+"]"));
            }
        } else {
            System.out.println("SECTION IN PROGRESS...");
        }
        try {
            for (Thread thread: threadList
            ) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mergeArray(arr, maxCountThreads, step, floats);
        logger.info("fillArrayWithMathThreads time:" + (System.currentTimeMillis() - time) + " Thread name:" + Thread.currentThread().getName());
    }

    private void mergeArray(float[] arr, int maxCountThreads, int step, List<float[]> floats) {
        long time = System.currentTimeMillis();
        for (int i = 0; i < maxCountThreads; i++) {
            System.arraycopy(floats.get(i), 0, arr,0, step);
        }
        logger.info("Merge Time: " + (System.currentTimeMillis() - time));
    }

    private void breakdownArray(float[] arr, int maxCountThreads, int step, List<float[]> floats) {
        long time = System.currentTimeMillis();
        for (int i = 0; i < maxCountThreads; i++) {
            floats.add(new float[step]);
            System.arraycopy(arr, i * step, floats.get(i), 0, step);
        }
        logger.info("Break Array Time:" + (System.currentTimeMillis() - time));
    }

    private void info(int i, int j) {
        if(i % j == 0 && false) {
            System.out.println("Изменен элемент:" + i + " Потоком "+ Thread.currentThread().getName());
        }
    }

    public void fillArrayOnesThread(float[] arr) {
        fillArrayOnesThread(arr,maxCountThreads);
    }

    public void fillArrayWithMathThreads(float[] arr) {
        fillArrayWithMathThreads(arr,maxCountThreads);
    }


    public long timeOperation(Method method, float[] floats)  {
        long time = System.currentTimeMillis();
        try {
            method.invoke(this, floats);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        logger.info(new StringBuilder().append("Время выполнения: ").append(String.valueOf(System.currentTimeMillis() - time)).toString());
        return (System.currentTimeMillis() - time);
    }

    public Thread threadStart(Runnable runnable, String name) {
        Thread thread = new Thread(runnable, name);
        thread.start();
        System.out.println("Start thread: " + name);
        return thread;
    }
}
