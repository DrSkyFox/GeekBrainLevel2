package LessonsOne;

import LessonsOne.interfaces.Jumaple;
import LessonsOne.interfaces.Passable;
import LessonsOne.interfaces.Runnerable;

import java.util.Random;

public class Robot implements Jumaple, Runnerable{

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
        this.jumHeight = new Random().nextDouble()*20;
        this.runDistance = new Random().nextInt(9000);
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
    public void pass(Passable passable) {
        System.out.println();
    }

    @Override
    public void jump(Jumaple jumaple) {

        if((jumaple.getHeightObject() > jumHeight) || !move) {
            System.out.println("Robot cant jump");
            move = false;
            return;
        }
        stageEnded++;
        System.out.println(new StringBuilder().append("Robot ").append(iD).append(" jumped").toString());
    }

    @Override
    public double getHeightObject() {
        return this.jumHeight;
    }

    @Override
    public void run(Runnerable runnerable) {
        if( (runnerable.getDistanceObject() > runDistance) || !move ) {
            System.out.println("Robot cant run");
            move = false;
            return;
        }
        stageEnded ++;
        System.out.println(new StringBuilder().append("Robot ").append(iD).append(" runned").toString());
    }

    @Override
    public double getDistanceObject() {
        return runDistance;
    }

    @Override
    public String toString() {
        return "Robot{" +
               "ID = " + iD +
               ", jumHeight=" + jumHeight +
               ", runDistance=" + runDistance +
               ", move=" + move +
               '}';
    }
}
