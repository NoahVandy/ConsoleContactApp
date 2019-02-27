package model;

public class PersonContact extends BaseContact{

	private String relationship;
	private String birthday;
	private String desc;
	
	public PersonContact(String name, String streetName, String city, String state, String postalCode, String country, String phoneNumber, String email, String photo, String relationship, String birthday, String desc) {
		super(name, streetName, city, state, postalCode, country, phoneNumber, photo, email);
		this.relationship = relationship;
		this.birthday = birthday;
		this.setDesc(desc);
	}
	
	public PersonContact() {
		super("Person name", "Another street", "Kansas City", "MO", "64124", "United States", "123-456-7890", "personPhoto.jpg", "person@gmail.com");
		this.relationship = "No relation yet";
		this.birthday = "No birthday yet";
		this.desc = "No description yet";
	}
	
	public String getRelationship() {
		return relationship;
	}
	
	public void setRelationship(String relation) {
		this.relationship = relation;
	}
	
	public String getBirthday() {
		return birthday;
	}
	
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	@Override
	public int compareTo(BaseContact o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "Name: " + name + ", Street Name: " + streetName + ", City: " + city + ", State: " + state
				+ ", Postal Code: " + postalCode + ", Country: " + country + ", Phone Number: " + phoneNumber
				+ ", Photo Name: " + photoName + ", Email: " + email + "Relationship: " + relationship + ", Birthday: " + birthday + ", Desription: " + desc;
	}

	
	

}
