package by.tc.task01.util.source_reader;

import by.tc.task01.dao.exception.DAOException;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ApplianceFileReader extends AutoCloseable {
    void openConnection() throws FileNotFoundException;
    String read() throws IOException;
}
