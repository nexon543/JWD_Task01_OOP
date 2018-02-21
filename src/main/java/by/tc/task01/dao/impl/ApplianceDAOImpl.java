package by.tc.task01.dao.impl;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.factory.ApplianceFactory;
import by.tc.task01.util.PropertyManager;
import by.tc.task01.util.PropertyManagerImpl;
import by.tc.task01.util.appliance_parser.ApplianceRecordParser;
import by.tc.task01.util.appliance_parser.ApplianceRecordParserImpl;

public class ApplianceDAOImpl implements ApplianceDAO, AutoCloseable{//  AutoCloseable - ЭЭЭЭЭЭЭЭЭЭЭ, что это, на реализации дао надо close вызывать? ЗАЧЕМ?

	ApplianceFactory applianceFactory;// атрибуты достапа, Карл, где атрибуты?
	ApplianceRecordParser applianceRecordParser;// плюс мы разбирали, почему в реализации дао, как и в реализации сервисов не должно быть полей экземпляра класса
	// на нескольких ревью разбирали - ты свои парсер предполагаешь делить между несколькими потоками, т.к. объект ApplianceDAOImpl у тебя будет в единственном экземпляре?
	SourceApplianceReader sourceApplianceReader;//ааа, вот зачем надо close вызывать, только такой код мутить для чтения properties - тебя самомго в это ничего не смущало

	public ApplianceDAOImpl() throws IOException {
		sourceApplianceReader=new SourceApplianceReader();
		applianceRecordParser=new ApplianceRecordParserImpl();
		applianceFactory=ApplianceFactory.getInstance();
	}
	
	public <E> List<Appliance> find(Criteria<E> criteria) throws IOException {
		List<Appliance> appliances=new ArrayList<Appliance>();
		String applianceRecord;
		while ((applianceRecord=sourceApplianceReader.read())!=null){
			if(!applianceRecord.trim().equals("")){
				Map <String, String> applianceProperties=applianceRecordParser.parse(applianceRecord);
				Appliance appliance=applianceFactory.getAppliance(applianceProperties);
				boolean isValid=criteria.checkApplianceCriteria(applianceProperties);
				if (isValid){
					appliances.add(appliance);
				}
			}
		}
		return appliances;
	}

	public void close() throws Exception {
		sourceApplianceReader.close();
	}
}


// почему эти классы не в своих файлах?

// на... такой огород городить, чтобы просто прочитать properties-файл
// да и по твоей логике, я должен его читать в каждом классе, где мне нужна инфа из пропертей - где логика?
class SourceNameReader {
	public String read () throws IOException   {
		String applianceDBPath=null;
		PropertyManager pm=new PropertyManagerImpl();
		pm.setPropertiesSourceFile("config.properties");
		applianceDBPath=pm.getProperty("applianceDBFile");
		System.out.println(applianceDBPath);
		return applianceDBPath;
	}
}

class SourceApplianceReader implements Closeable {
	private String sourceName;
	private BufferedReader fileReader;
	
	public SourceApplianceReader()  throws IOException {
		SourceNameReader snr=new SourceNameReader();
		sourceName=snr.read();
		FileReader fr = new FileReader(sourceName);
		fileReader=new BufferedReader (fr);
	}
	public String read() throws IOException {
		if (fileReader == null) {
			throw new FileNotFoundException();
		}
		return fileReader.readLine();
	}
	
	
	public void close() throws IOException {
		fileReader.close();
		
	}
}
