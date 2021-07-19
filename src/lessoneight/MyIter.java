package lessoneight;

interface MyIter<T> {
    void add(String o);

    void remove(String o);

    T next();

    boolean hasNext();

    void set(T t);

    T get();
}
