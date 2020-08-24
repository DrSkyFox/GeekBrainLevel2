package LessonsOne;

import LessonsOne.interfaces.Passable;
import LessonsOne.track.Road;
import LessonsOne.track.Wall;

import java.util.Random;

public class MainApp {
    public static void main(String[] args) {
        Random random = new Random();

        Passable[] testSubjects = new Passable[]{
                new Cat(),
                new Human(),
                new Robot()
        };


        Passable[] objects = new Passable[] {
                new Road(random.nextInt(7000)),
                new Wall(random.nextInt(2)),
                new Road(random.nextInt(7000)),
                new Wall(random.nextInt(2))
        };
        runAndJump(testSubjects, objects);
    }

    private static void runAndJump(Passable[] runnable, Passable[] track) {
        int stage = 0;

        for (Passable passable: track
             ) {
            for (Passable r: runnable
                 ) {
                passable.pass(r);
            }
        }


    }

}
