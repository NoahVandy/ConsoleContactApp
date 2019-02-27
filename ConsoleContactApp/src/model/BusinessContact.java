package model;

import java.util.Arrays; 
import java.util.List;


public class BusinessContact extends BaseContact{
	private String desc;
	private String open;
	private String close;
	private Boolean[] daysOfWeekOpen;
	private String url;
	
	
	public BusinessContact(String name, String streetName, String city, String state, String postalCode, String country, String phoneNumber, String email, String photo, String desc, String open, String close, Boolean[] days, String url) {
		super(name, streetName, city, state, postalCode, country, phoneNumber, photo, email);
		this.desc = desc;
		this.open = open;
		this.close = close;
		this.daysOfWeekOpen = days;
		this.url = url;
		
	}
	public BusinessContact() {
		super("Business Name", "Another street", "Kansas City", "MO", "64124", "United States", "816-123-4567", "businessStoreFront.jpg", "business@gmail.com");
		this.open = "12:00am";
		this.close = "12:00pm";
		this.daysOfWeekOpen = new Boolean[] {false,true,true,true,true,true,false};
		this.url = "https://somewhere.com";
	}


	public String getOpen() {
		return open;
	}

	public void setOpen(String opening) {
		this.open = opening;
	}

	public String getClose() {
		return close;
	}

	public void setClose(String closing) {
		this.close = closing;
	}

	public Boolean[] getDaysOfWeekOpen() {
		return daysOfWeekOpen;
	}

	public void setDaysOfWeekOpen(Boolean[] daysOfWeekOpen) {
		this.daysOfWeekOpen = daysOfWeekOpen;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Name: " + name + ", Street Name: " + streetName + ", City: " + city + ", State: " + state
				+ ", Postal Code: " + postalCode + ", Country: " + country + ", Phone Number: " + phoneNumber
				+ ", Photo Name: " + photoName + ", Email: " + email + "Description: " + desc + ", Open: " + open + ", Close: " + close + ", Days Of Week Open: "
				+ Arrays.toString(daysOfWeekOpen) + ", Website Link" + url;
	}
	@Override
	public int compareTo(BaseContact o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

	
	
	
}
