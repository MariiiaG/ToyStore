package model;

import model.toys.Toy;
import model.toys.ToyStore;
import model.writer.FileHandler;
import model.writer.Writable;

import java.util.Random;

public class Service {
    FileHandler fileHandler = new FileHandler();
    Random random = new Random();

    private Writable writable;
    private ToyStore<Toy> toys;

    public Service(ToyStore<Toy> toys) {
        this.toys = toys;
    }
    public Service() {
        toys = new ToyStore<>();
    }
    public boolean save() {
        if (writable == null) {
            return false;
        }
        return writable.save(toys);
    }
    public boolean load() {
        if (writable == null) {
            return false;
        }
        toys = writable.read();
        return true;
    }

    public String addToy(String name, long amount, long weight) {

        Toy toy = new Toy(name, amount, weight);
        toys.add(toy);
        return "Successfully added a new toy to the Store";
    }
    public void setWritable(Writable writable) {
        this.writable = writable;
    }
    public String getToysList() {
        return toys.getInfo();
    }

}
