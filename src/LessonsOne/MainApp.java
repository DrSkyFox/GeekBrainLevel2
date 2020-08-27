package LessonsOne;

import LessonsOne.interfaces.Passable;
import LessonsOne.track.Road;
import LessonsOne.track.Wall;

import java.util.Random;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int maxObjects;

        Passable[] testSubjects = new Passable[]{
                new Cat(),
                new Human(),
                new Robot()
        };

        infoAboutSubjects(testSubjects);

        System.out.println("Enter max objects:" );
        maxObjects = scanner.nextInt();
        Passable[] objects = new Passable[maxObjects];

        for (int i = 0; i < maxObjects; i++) {
            if(random.nextBoolean()) {
                objects[i] = new Wall((random.nextDouble()*2));
            } else {
                objects[i] = new Road(random.nextInt(3000));
            }
        }

        runAndJump(testSubjects, objects);

        infoAboutSubjects(testSubjects);

    }

    private static void infoAboutSubjects(Passable[] testSubjects) {
        for (Passable passable : testSubjects
        ) {
            passable.info();
        }
    }

    private static void runAndJump(Passable[] runnable, Passable[] track) {
        int stage = 0;

        for (Passable passable: track
             ) {
            passable.info();
            for (Passable r: runnable
                 ) {
                passable.pass(r);
            }
        }


    }

}
