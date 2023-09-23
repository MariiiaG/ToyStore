package model.toys;

import java.util.Iterator;
import java.util.List;

public class ToysIterator<T extends Node<T>> implements Iterator<T> {
    private List<T> list;
    private int index;

    public ToysIterator(List<T> list) {
        this.list = list;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public T next() {
        return list.get(index++);
    }
}
