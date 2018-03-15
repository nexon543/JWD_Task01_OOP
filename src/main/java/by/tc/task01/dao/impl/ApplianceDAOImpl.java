package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.exception.DAOException;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.ApplianceType;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.appliance_factory.ApplianceFactoryClient;
import by.tc.task01.service.appliance_factory.LaptopFactory;
import by.tc.task01.service.validation.CriteriaChecker;
import by.tc.task01.util.appliance_parser.ApplianceRecordParser;
import by.tc.task01.util.appliance_parser.ApplianceRecordParserImpl;
import by.tc.task01.util.source_reader.ApplianceFileReader;
import by.tc.task01.util.source_reader.ApplianceFileReaderImpl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ApplianceDAOImpl implements ApplianceDAO {

    private String EMPTY_STRING="";
    private CriteriaChecker criteriaChecker;
    private ApplianceRecordParser applianceRecordParser;
    private ApplianceFactoryClient applianceFactoryClient;

    public ApplianceDAOImpl() {
        applianceRecordParser = new ApplianceRecordParserImpl();
        applianceFactoryClient = new ApplianceFactoryClient();
        criteriaChecker = new CriteriaChecker();
        applianceFactoryClient.addFactroy(ApplianceType.LAPTOP, new LaptopFactory());
    }

    public <E> List<Appliance> find(Criteria<E> criteria) throws DAOException {

        List<Appliance> applianceList = new ArrayList<>();
        String applianceRecord;
        try (ApplianceFileReader applianceFileReader = new ApplianceFileReaderImpl()) {
            while ((applianceRecord = applianceFileReader.read()) != null) {
                if (!applianceRecord.trim().equals(EMPTY_STRING)) {
                    Map<String, String> applianceProperties = applianceRecordParser.parse(applianceRecord);
                    boolean isValid = criteriaChecker.check(applianceProperties, criteria);
                    if (isValid) {
                        Appliance appliance = applianceFactoryClient.getAppliance(applianceProperties);
                        applianceList.add(appliance);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new DAOException(DAOException.CONFIG_FILE_ERROR);
        } catch (IOException e) {
            throw new DAOException(DAOException.RECORD_ERROR);
        } catch (Exception e) {
            throw new DAOException(DAOException.SOURCE_ERROR);
        }

        return applianceList;
    }
}