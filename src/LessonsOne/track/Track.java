package LessonsOne.track;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Track {

    private Random random;
    private int object_count;
    private List<Object> objects;

    public Track(List<Object> objects) {
        this.objects = objects;
    }

    public Track(int object_count) {
        this.object_count = object_count;
        random = new Random();
        objects = new ArrayList<>();
        for (int i = 0; i < object_count; i++) {
            if(random.nextBoolean()) {
                objects.add(new Wall(random.nextInt(3)));
            } else {
                objects.add(new Road(random.nextInt(500*(i+1))));
            }
        }
    }

    public List<Object> getObjects() {
        return objects;
    }

    public void setObjects(List<Object> objects) {
        this.objects = objects;
    }
}
