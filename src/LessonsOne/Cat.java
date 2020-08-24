package LessonsOne;

import LessonsOne.interfaces.Jumaple;
import LessonsOne.interfaces.Passable;
import LessonsOne.interfaces.Runnerable;

import java.util.Random;

public class Cat implements Jumaple, Runnerable {

    private double jumHeight;
    private int runDistance;
    private static int iD;
    private boolean move;
    private int stageEnded;

    public Cat(int jumHeight, int runDistance) {
        this.jumHeight = jumHeight;
        this.runDistance = runDistance;
        ++iD;
        move = true;
    }


    public Cat() {
        this.jumHeight = new Random().nextDouble()*2;
        this.runDistance = new Random().nextInt(400);
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
            System.out.println("Cat cant jump");
            move = false;
            return;
        }
        stageEnded++;
        System.out.println(new StringBuilder().append("Cat ").append(iD).append(" jumped").toString());
    }

    @Override
    public double getHeightObject() {
        return this.jumHeight;
    }

    @Override
    public void run(Runnerable runnerable) {
        if( (runnerable.getDistanceObject() > runDistance) || !move ) {
            System.out.println("Cat cant run");
            move = false;
            return;
        }
        stageEnded ++;
        System.out.println(new StringBuilder().append("Cat ").append(iD).append(" runned").toString());
    }

    @Override
    public double getDistanceObject() {
        return runDistance;
    }

    @Override
    public String toString() {
        return "Cat{" +
               "ID = " + iD +
               ", jumHeight=" + jumHeight +
               ", runDistance=" + runDistance +
               ", move=" + move +
               '}';
    }
}
