package by.tc.task01.dao.impl;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

public class ApplianceDAOImpl implements ApplianceDAO{

	@Override
	public <E> Appliance find(Criteria<E> criteria) {
		SourceApplianceReader.read();
		
		
		
		return null;
	}
	
	// you may add your own code here

}


class SourceNameReader {
	public static String read () {
		return "appliance_db.txt";
	}
}

class SourceApplianceReader implements Closeable {
	public static final String sourceName;
	
	public static BufferedReader fileReader;
	public static String read() throws IOException {
		if (fileReader == null) {
			throw new FileNotFoundException();
		}
		return fileReader.readLine();
	}
	
	static  { 
		sourceName=SourceNameReader.read();
		try {
			fileReader=new BufferedReader (new FileReader(sourceName));
		} catch (FileNotFoundException e) {
			fileReader=null;
			e.printStackTrace();
		}
		
	}
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}
	
}