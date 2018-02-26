package by.tc.task01.util.source_reader;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class SourceApplianceReader implements Closeable{
  private String sourceName;
  private BufferedReader sourceReader;

  public SourceApplianceReader()  throws IOException {
    SourceNameReader sourceNameReader=new SourceNameReader("config.properties", "applianceDBFile");
    sourceName=sourceNameReader.read();
    FileReader fileReader = new FileReader(sourceName);
    sourceReader=new BufferedReader (fileReader);
  }
  public String read() throws IOException {
    if (sourceReader == null) {
      throw new FileNotFoundException();
    }
    return sourceReader.readLine();
  }

  public void reset() throws IOException{
    try{
      sourceReader.close();
    }
    catch (Exception ex){}
    FileReader fileReader = new FileReader(sourceName);
    sourceReader=new BufferedReader (fileReader);
  }
  public void close() throws IOException {
    sourceReader.close();
  }
}
