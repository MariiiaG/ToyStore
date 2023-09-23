package model.writer;

import model.toys.Toy;
import model.toys.ToyStore;

import java.io.Serializable;

public class ToyStoreFileHandler extends FileHandler implements Writable{
    private String filePath = "/Users/mariagadova/IdeaProjects/ToyStore/toys.txt";
    @Override
    public boolean save(ToyStore<Toy> toys) {
        return super.save((Serializable) toys, filePath);
    }

    @Override
    public ToyStore<Toy> read() {
        return (ToyStore<Toy>) super.read(filePath);
    }

    @Override
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}