package by.tc.task01.util.source_reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ApplianceFileReaderImpl implements ApplianceFileReader {

    private SourceNameReader sourceNameReader;
    private String filePath;
    private BufferedReader fileReader;

    public ApplianceFileReaderImpl() throws IOException {
        sourceNameReader = new SourceNameReader();
        filePath = sourceNameReader.readApplianceFilePath();
        fileReader = new BufferedReader(new FileReader(filePath));
    }

    public String read() throws IOException {
        return fileReader.readLine();
    }

    public void close() throws IOException {
        fileReader.close();

    }
}