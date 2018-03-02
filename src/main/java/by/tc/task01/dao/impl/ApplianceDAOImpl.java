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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ApplianceDAOImpl implements ApplianceDAO {

    ApplianceFileReader applianceFileReaderImpl;
    CriteriaChecker criteriaChecker;
    ApplianceRecordParser applianceRecordParser;
    ApplianceFactoryClient applianceFactoryClient;

    public ApplianceDAOImpl() {
        applianceRecordParser = new ApplianceRecordParserImpl();
        applianceFactoryClient = new ApplianceFactoryClient();
        criteriaChecker = new CriteriaChecker();
        applianceFactoryClient.addFactroy(ApplianceType.LAPTOP, new LaptopFactory());
        applianceFileReaderImpl = new ApplianceFileReaderImpl();
    }

    public <E> List<Appliance> find(Criteria<E> criteria) throws DAOException {
        try {
            applianceFileReaderImpl.openConnection();
        } catch (IOException ex) {
            throw new DAOException(DAOException.SOURCE_ERROR);
        }
        List<Appliance> applianceList = new ArrayList<Appliance>();
        String applianceRecord;
        try {
            while ((applianceRecord = applianceFileReaderImpl.read()) != null) {
                if (!applianceRecord.trim().equals("")) {
                    Map<String, String> applianceProperties = applianceRecordParser.parse(applianceRecord);
                    boolean isValid = criteriaChecker.check(applianceProperties, criteria);
                    if (isValid) {
                        Appliance appliance = applianceFactoryClient.getAppliance(applianceProperties);
                        applianceList.add(appliance);
                    }
                }
            }

        } catch (IOException ex) {
            throw new DAOException(DAOException.RECORD_ERROR);
        }
        try {
            applianceFileReaderImpl.close();
        } catch (Exception ex) {
            throw new DAOException(DAOException.SOURCE_CLOSE_EXCEPTION);
        }

        return applianceList;
    }
}