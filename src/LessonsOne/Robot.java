package LessonsOne;

import LessonsOne.interfaces.JumpAndRunnable;
import LessonsOne.track.Road;
import LessonsOne.track.Wall;

import java.util.Random;

public class Robot implements JumpAndRunnable {

    private double jumHeight;
    private int runDistance;
    private static int iD;
    private boolean move;
    private int stageEnded;

    public Robot(int jumHeight, int runDistance) {
        this.jumHeight = jumHeight;
        this.runDistance = runDistance;
        ++iD;
        move = true;
    }


    public Robot() {
        this.jumHeight = new Random().nextDouble()*10;
        this.runDistance = new Random().nextInt(12000);
        ++iD;
        move = true;
    }

    public boolean isMove() {
        return move;
    }

    public void setMove(boolean move) {
        this.move = move;
    }

    @Override
    public void stageComplete() {
        System.out.println("Robot" + iD +"-> Stage completed: " + stageEnded);
    }

    @Override
    public void jump(Wall wall) {
        if((wall.getHeight() > jumHeight) || !move) {
            System.out.println("Robot cant jump");
            move = false;
            return;
        }
        stageEnded++;
        System.out.println(new StringBuilder().append("Robot ").append(iD).append(" jumped").toString());
    }

    @Override
    public void run(Road road) {
        if((road.getLen() > runDistance) || !move) {
            System.out.println("Robot cant run");
            move = false;
            return;
        }
        stageEnded++;
        System.out.println(new StringBuilder().append("Robot ").append(iD).append(" runned").toString());
    }

    @Override
    public String toString() {
        return "Robot{" +
               "ID = "+ iD  +
               ", jumHeight=" + jumHeight +
               ", runDistance=" + runDistance +
               ", move=" + move +
               '}';
    }
}
