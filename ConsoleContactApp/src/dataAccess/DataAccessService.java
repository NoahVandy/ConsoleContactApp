package dataAccess;

import businesServices.BusinessService;

public interface DataAccessService {

	public BusinessService readAllData();
	
	public void writeAllData(BusinessService contactApp);
	
}
