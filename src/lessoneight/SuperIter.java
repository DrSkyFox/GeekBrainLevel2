package lessoneight;

public interface SuperIter<T> extends MyIter<T> {

    void add(T o);

    void remove(T o);

    T next();

    T prev();

    boolean hasNext();

    boolean hasPrev();

    void set(T t);

    T get();
}
