package model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME, 
		include = JsonTypeInfo.As.PROPERTY, 
		property = "type")
@JsonSubTypes({ 
	@Type(value = BusinessContact.class, name = "BusinessContact"), 
	@Type(value = PersonContact.class, name = "PersonContact") 
})

public abstract class BaseContact implements Comparable<BaseContact> {
	protected String name;
	protected String streetName;
	protected String city;
	protected String state;
	protected String postalCode;
	protected String country;
	protected String phoneNumber;
	protected String photoName;
	protected String email;
	
	
	public BaseContact(String name, String streetName, String city, String state, String postalCode, String country,
			String phoneNumber, String photoName, String email) {
		super();
		this.name = name;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
		this.phoneNumber = phoneNumber;
		this.photoName = photoName;
		this.email = email;
	}
	
	//default constructor
	
	public BaseContact() {
		this.name = "'There has not been a name given yet'";
		this.streetName = "123 Main st";
		this.city = "Kansas City";
		this.state = "MO";
		this.postalCode = "64124";
		this.country = "United States";
		this.phoneNumber = "123-456-7890";
		this.photoName = "myPic.jpg";
		this.email = "email@my.com";
	}

	@Override
	public String toString() {
		return "Name: " + name + ", Street Name: " + streetName + ", City: " + city + ", State: " + state
				+ ", Postal Code: " + postalCode + ", Country: " + country + ", Phone Number: " + phoneNumber
				+ ", Photo Name: " + photoName + ", Email: " + email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void callContact() {
		System.out.println("Now calling " + this.name);
	}
	public void textContact() {
		System.out.println("Now texting " + this.phoneNumber);
	}
	public void navigateToContact() {
		System.out.println("Now navigating to " + this.streetName + this.state + this.country);
	}
	public void emailContact() {
		System.out.println("Now emailing " + this.email);
	}
	
	@Override
	public int compareTo(BaseContact other) {

		int compareResult = this.name.compareTo(other.name);

		if (compareResult == 0) {
			return this.name.compareTo(other.name);
		} else {
			return compareResult;
		}
	}
}
