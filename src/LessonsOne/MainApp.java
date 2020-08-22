package LessonsOne;

import LessonsOne.interfaces.JumpAndRunnable;
import LessonsOne.track.Road;
import LessonsOne.track.Track;
import LessonsOne.track.Wall;

public class MainApp {
    public static void main(String[] args) {
        JumpAndRunnable[] testSubjects = new JumpAndRunnable[] {
                new Cat(),
                new Human(),
                new Robot()
        };

        Track track = new Track(15);

        runAndJump(testSubjects, track);
        for (JumpAndRunnable jaR: testSubjects
             ) {
            jaR.stageComplete();
        }
    }

    private static void runAndJump(JumpAndRunnable[] runnable, Track track) {
        int stage = 0;
        for (Object o: track.getObjects()
             ) {
            System.out.println("Stage: " + (++stage));
            switch (o.getClass().getName()) {
                case "LessonsOne.track.Wall":
                    System.out.println("Препятсвие Wall: "  + ((Wall) o).getHeight());
                    for (JumpAndRunnable r: runnable
                         ) {
                        r.jump((Wall) o);
                    }
                    break;
                case "LessonsOne.track.Road":
                    System.out.println("Препятсвие Road: "  + ((Road) o).getLen());
                    for (JumpAndRunnable r: runnable
                         ) {
                        r.run((Road) o);
                    }
                    break;
            }
        }
    }

}
