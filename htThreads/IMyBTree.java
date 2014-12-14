package htThreads;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by forenc on 05.12.2014.
 */
// Интерфейс класа двоичного дерева
public interface IMyBTree<T extends Comparable<T>> {
    public IMyBTree getLeft();
    public IMyBTree getRight();
    public T getvalue();
    public void add(T value);
    public AtomicInteger getcount();
}
