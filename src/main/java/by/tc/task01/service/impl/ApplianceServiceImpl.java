package by.tc.task01.service.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.dao.exception.DAOException;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.exception.ServiceException;
import by.tc.task01.service.validation.Validator;

import java.util.ArrayList;
import java.util.List;

public class ApplianceServiceImpl implements ApplianceService {

    String applianceFilePath;
    public <E> List<Appliance> find(Criteria<E> criteria) throws ServiceException {
        if (!Validator.criteriaValidator(criteria)) {
            return null;
        }
        List<Appliance> appliances = new ArrayList<Appliance>();
        DAOFactory factory = DAOFactory.getInstance();
        ApplianceDAO  applianceDAO;
        applianceDAO = factory.getApplianceDAO();
        try {
            appliances = applianceDAO.find(criteria);
        } catch (DAOException ex) {
            if (ex.getErrorCode() == DAOException.RECORD_ERROR) {
                throw new ServiceException(ServiceException.CRITERIA_TYPE_ERROR);
            }
            if (ex.getErrorCode() == DAOException.SOURCE_ERROR) {
                throw new ServiceException(ServiceException.FILE_NAME_ERROR);
            }
        }
        return appliances;
    }

    @Override
    public void applianceFilePath(String applianceFilePath) {
        this.applianceFilePath=applianceFilePath;
    }

}
