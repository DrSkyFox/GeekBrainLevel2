package LessonsOne.interfaces;

import LessonsOne.track.Road;
import LessonsOne.track.Wall;

public interface JumpAndRunnable {
    void jump(Wall wall);
    void run(Road road);
    void stageComplete();
}
