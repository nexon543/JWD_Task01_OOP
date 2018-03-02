package by.tc.task01.dao;

import by.tc.task01.dao.exception.DAOException;
import by.tc.task01.dao.impl.ApplianceDAOImpl;

public final class DAOFactory {

    private static final DAOFactory instance;

    static {
        try {
            instance = new DAOFactory();
        } catch (Exception ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    private ApplianceDAO applianceDAO;

    private DAOFactory() throws DAOException {
        applianceDAO = new ApplianceDAOImpl();
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public ApplianceDAO getApplianceDAO() {
        return applianceDAO;
    }
}