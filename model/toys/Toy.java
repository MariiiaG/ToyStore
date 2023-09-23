package model.toys;

import java.io.Serializable;

public class Toy implements Serializable, Node<Toy> {
    private long id;
    private String name;
    private long amount;
    private long weight;

    public Toy(String name, long amount, long weight) {
        id = -1;
        this.name = name;
        this.amount = amount;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", weight=" + weight +
                '}';
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }
}
