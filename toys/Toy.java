package toys;

import java.util.Objects;

public class Toy implements Comparable<Toy> {

    private int toyId;
    private String toyName;
    private int toyWeight;

    public Toy(int toyId, String toyName, int toyWeight) {
        this.toyId = toyId;
        this.toyName = toyName;
        this.toyWeight = toyWeight;
    }

    public int getToyId() {
        return toyId;
    }

    public String getToyName() {
        return toyName;
    }

    public int getToyWeight() {
        return toyWeight;
    }

    public void setToyWeight(int toyWeight) {
        this.toyWeight = toyWeight;
    }

    public String getInfo() {
        return String.format("ID: %d, Name: %s", toyId, toyName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Toy toy = (Toy) o;
        return toyName.equals(toy.toyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(toyName);
    }

    @Override
    public int compareTo(Toy o) {
        return Integer.compare(this.toyWeight, o.toyWeight);
    }

}
