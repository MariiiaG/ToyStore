package model.writer;

import model.toys.Toy;
import model.toys.ToyStore;

public interface Writable {
    boolean save (ToyStore<Toy> toys);
    ToyStore<Toy> read();
    void setFilePath(String filePath);
}
