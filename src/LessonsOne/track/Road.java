package LessonsOne.track;


import LessonsOne.interfaces.Passable;
import LessonsOne.interfaces.Runnerable;

public class Road implements Runnerable {
    private int len;

    public Road(int len) {
        this.len = len;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    @Override
    public void run(Runnerable runnerable) {
        runnerable.run(this);
    }

    @Override
    public double getDistanceObject() {
        return getLen();
    }

    @Override
    public void pass(Passable passable) {
        run((Runnerable) passable);
    }

    @Override
    public void info() {
        System.out.println("Road have distance: " + getLen());
    }
}
