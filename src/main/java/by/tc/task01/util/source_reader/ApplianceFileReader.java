package by.tc.task01.util.source_reader;

import java.io.IOException;

public interface ApplianceFileReader extends AutoCloseable {
    String read() throws IOException;
}
