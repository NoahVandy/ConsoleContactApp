package businesServices;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dataAccess.DataAccessService;  
import dataAccess.FileIOService;
import model.AddressBook;

public class BusinessService {

	public AddressBook list;
	
	public BusinessService(AddressBook list) {
		super();
		this.setList(list);
	}
	
	public BusinessService() {
		super();
		this.setList(new AddressBook());
	}
	
	
	public void saveAllLists(AddressBook list) {
	
		DataAccessService das = new FileIOService();
		das.writeAllData(this);
		

	}
	
	public AddressBook loadAllLists() {
		DataAccessService das = new FileIOService();
		return das.readAllData().getList();
	}
	
	public AddressBook getList() {
		return list;
	}
	
	public void setList(AddressBook list) {
		this.list = list;
	}

	public String toString() {
		return list.getTheList().toString();
		
	}
	
	
	
}
