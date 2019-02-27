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
		ObjectMapper om = new ObjectMapper();
		
		try {
			om.writerWithDefaultPrettyPrinter().writeValue(new File("Contacts.json"), list);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public AddressBook loadAllLists() {
		try {
			AddressBook list = new AddressBook();
			
			list = new ObjectMapper().readerFor(BusinessService.class).readValue(new File("Contacts.json"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
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
