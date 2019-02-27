package model;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {

	// this is the main data storage for the entire program
	// going to be using generics in this class

	private List<BaseContact> theList;
	// the constructor will create an empty list of BaseContacts

	public AddressBook() {
		this.theList = new ArrayList<BaseContact>();
	}

	// add one person or business to the list
	// add them by using <T>
	// this tells the computer that it can use any class inherited by the
	// BaseContact
	public <T extends BaseContact> void addOne(T contact) {
		this.theList.add(contact);
	}

	// delete a contact from the list. Return true for success and false for failure
	public <T extends BaseContact> boolean deleteOne(T contact) {
		if (theList.contains(contact)) {
			this.theList.remove(contact);
			return true;
		} else {
			return false;
		}
	}

	public int searchFor(String search, int i) {
		//this loop checks every item in the list
			//if statement checks to see if there is a match to every property
			if (theList.get(i).getName().contains(search) || theList.get(i).getPhoneNumber().contains(search) || theList.get(i).getStreetName().contains(search) || theList.get(i).getState().contains(search) || theList.get(i).getPostalCode().contains(search) || theList.get(i).getName().contains(search) || theList.get(i).getCountry().contains(search) || theList.get(i).getPhotoName().contains(search) || theList.get(i).getEmail().contains(search)) {
				//returns the number in the contact list if it finds one
				return i;
			} 
		
		//returns -1 if it doesnt find one
		return -1;

	}
		public int searchFor(String search) {
		//this loop checks every item in the list
		for (int i = 0; i < theList.size(); i++) {
			//if statement checks to see if there is a match to every property
			if (theList.get(i).getName().contains(search) || theList.get(i).getPhoneNumber().contains(search) || theList.get(i).getStreetName().contains(search) || theList.get(i).getState().contains(search) || theList.get(i).getPostalCode().contains(search) || theList.get(i).getName().contains(search) || theList.get(i).getCountry().contains(search) || theList.get(i).getPhotoName().contains(search) || theList.get(i).getEmail().contains(search)) {
				//returns the number in the contact list if it finds one
				return i;
			} 
		}
		//returns -1 if it doesnt find one
		return -1;

	}

	public List<BaseContact> getTheList() {
		return theList;
	}

	public void setTheList(List<BaseContact> theList) {
		this.theList = theList;
	}

	@Override
	public String toString() {
		return "AddressBook " + theList;
	}

	
	
	
}
