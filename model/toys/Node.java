package model.toys;

import java.time.LocalDate;
import java.util.List;

public interface Node<T> {

    void setId (long id);
    long getId();
    String getName();

}
