package model.toys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ToyStore<T extends Node<T>> implements Serializable, Iterable<T>{

    private long toysId;
    private List<T> toysList;

    public ToyStore(List<T> humanList) {
        this.toysList = humanList;
    }

    public ToyStore() {
        this(new ArrayList<>());
    }

    public boolean add(T toy) {
        if (toy == null) {
            return false;
        }
        if (!toysList.contains(toy)) {
            toysList.add(toy);
            toy.setId(toysId++);

            return true;
        }
        return false;
    }


    public List<T> getByName(String name) {
        List<T> res = new ArrayList<>();
        for (T toy: toysList) {
            if (toy.getName().equalsIgnoreCase(name)) {
                res.add(toy);
            }
        }
        return res;
    }


    public boolean remove(long toysIdId) {
        if (checkId(toysIdId)) {
            T e = getById(toysIdId);
            return toysList.remove(e);
        }
        return false;
    }

    private boolean checkId(long id) {
        if (id >= toysId || id < 0) {
            return false;
        }
        for (T human: toysList) {
            if (human.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public T getById(long id) {
        for (T human: toysList) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Toys in the store : ");
        sb.append(toysList.size());
        sb.append(" total amount: \n");
        for (T toy: toysList) {
            sb.append(toy);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }
    @Override
    public Iterator<T> iterator() {
        return new ToysIterator<>(toysList);
    }

}
