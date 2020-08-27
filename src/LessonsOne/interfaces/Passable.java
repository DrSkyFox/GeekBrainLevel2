package LessonsOne.interfaces;

public interface  Passable {
    void pass(Passable passable);
    default void info() {
        System.out.println("This has not info");
    }


}
