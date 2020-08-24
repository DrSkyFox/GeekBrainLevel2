package LessonsOne.track;

import LessonsOne.interfaces.Jumaple;
import LessonsOne.interfaces.Passable;

public class Wall implements Jumaple {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void jump(Jumaple jumaple) {
        jumaple.jump(this);
    }

    @Override
    public double getHeightObject() {
        return getHeight();
    }

    @Override
    public void pass(Passable passable) {
        jump((Jumaple) passable);
    }

}
