package by.tc.task01.util.source_reader;

import by.tc.task01.dao.exception.DAOException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ApplianceFileReaderImpl implements ApplianceFileReader {

    private String filePath;
    private BufferedReader fileReader;

    public ApplianceFileReaderImpl() {
        setSourceNameFromProperties();
    }

    public ApplianceFileReaderImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void openConnection() throws FileNotFoundException {
        FileReader fileReader = new FileReader(filePath);
        this.fileReader = new BufferedReader(fileReader);
    }

    public String read() throws IOException {
        return fileReader.readLine();
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setSourceNameFromProperties() {
        SourceNameReader sourceNameReader = new SourceNameReader();
        filePath = sourceNameReader.readApplianceFilePath();
    }

    public void close() throws IOException {
        fileReader.close();
    }

    public String getFilePath() {
        return filePath;
    }
}