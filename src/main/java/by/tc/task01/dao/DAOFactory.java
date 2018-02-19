package by.tc.task01.dao;

import java.io.IOException;

import by.tc.task01.dao.impl.ApplianceDAOImpl;

public final class DAOFactory {
	
	private static final DAOFactory instance;

	static {
		try {
			instance=new DAOFactory();
		}
		catch (Exception ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}
	private final ApplianceDAO applianceDAO;
	
	private DAOFactory() throws IOException {
		applianceDAO = new ApplianceDAOImpl();
		}

	public ApplianceDAO getApplianceDAO() {
		return applianceDAO;
	}

	public static DAOFactory getInstance() {
		return instance;
	}

}
