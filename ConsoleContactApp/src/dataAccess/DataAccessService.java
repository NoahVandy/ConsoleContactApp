package dataAccess;

import businesServices.BusinessService;

public interface DataAccessService {

	public BusinessService readAllData();
	
	boolean writeAllData(BusinessService contactApp);
	
}
