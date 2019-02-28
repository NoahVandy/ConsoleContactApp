package dataAccess;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import businesServices.BusinessService;
import model.AddressBook;

public class FileIOService implements DataAccessService {

	@Override
	public BusinessService readAllData() {
		BusinessService bs = new BusinessService();
		
		try {
			bs = new ObjectMapper().readerFor(BusinessService.class).readValue(new File("Contacts.json"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bs;
	}

	@Override
	public void writeAllData(BusinessService bs) {
	ObjectMapper om = new ObjectMapper();
		
		try {
			om.writerWithDefaultPrettyPrinter().writeValue(new File("Contacts.json"), bs);
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

}
