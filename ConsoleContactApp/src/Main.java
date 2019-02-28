import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import businesServices.BusinessService;
import model.AddressBook;
import model.BaseContact;
import model.BusinessContact;
import model.PersonContact;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BusinessService bs = new BusinessService();
		bs.list = bs.loadAllLists();
//
//		// making a new person
//		System.out.println("<-------Making new person------->");
//		
//		//displaying new person
//		System.out.println(NV);
		// adding new person to address book
//		System.out.println(bs.list.toString());
//		
//		
//		//making new business contact
//		System.out.println("<-------Making new business------>");
//		//display new business
//		
//		System.out.println("Search for Noah Vandervelden");
//		System.out.println(bs.getList().searchFor("Noah Vandervelden"));
//		System.out.println(bs.getList().searchFor("Grand Canyon University"));
//		
//		//delete a contact
//		bs.list.deleteOne(NV);
//		
//		//call, text, navigate to, and email a contact
//		
//		bs.list.getTheList().get(0).callContact();
//		bs.list.getTheList().get(0).textContact();
//		bs.list.getTheList().get(0).navigateToContact();
//		bs.list.getTheList().get(0).emailContact();
//		
//		
//		System.out.println("<-------New person added------>");

//		//displaying the entire list
//		System.out.println(bs.list);

		// this is the start of milestone2
		Scanner kb = new Scanner(System.in);

		String decision = "";

		// asking the user for a decision
		System.out.println("'Add', 'Delete', 'Search', 'Display', 'Edit', 'Contact', 'Save', 'Load', 'Exit'");
		// this while loop will run until the user types in "exit"
		while (!decision.equalsIgnoreCase("Exit")) {
			decision = kb.nextLine();
			switch (decision) {
			case "Add":
				System.out.println(
						"Please enter 'Personal' or 'Business' for what kind of contact you would like to add");
				String contactInfo = kb.nextLine();
				switch (contactInfo) {
				// this is getting all of the info through a scanner
				case "Personal":
					addNewPersonal(bs);
					break;

				case "Business":
					addNewBusiness(bs);
					break;
				}
				break;
			case "Edit":
				editContact(bs);
				break;

			case "Delete":
				deleteContact(bs);
				break;
			case "Search":
				searchContact(bs);
				break;
			case "Display":
				System.out.println(
						"Please eneter 'All' if you would like to display all, or 'Show 1' and then enter the number you would like to display");
				String displayChoice = kb.nextLine();
				switch (displayChoice) {
				case "All":
					showAll(bs);
					break;
				case "Show 1":
					showOne(bs);
					break;
				}
				break;
			case "Contact":
				System.out.println(
						"Please enter if you would like to 'Call', 'Text', 'Email', 'Navigate'");
				String contactChoice = kb.nextLine();
				switch (contactChoice) {
				case "Call":
					callContact(bs);
					break;
				case "Text":
					textContact(bs);
					break;
				case "Email":
					emailContact(bs);
					break;
				case "Navigate":
					navigateContact(bs);
					break;
				}
				break;
			case "Save":
				bs.saveAllLists(bs.list);
				break;
			case "Load":
				loadList(bs);
				break; 
			default:
				System.out.println(
						"Please enter one of the valid commands, 'Add', 'Delete', 'Search', 'Exit', and make sure that your input matches exactly");
			}

		}

	}
	
	public static void navigateContact(BusinessService bs) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Please enter the number in the list you would like to navigate to");
		String displayShow1 = kb.nextLine();
		try {
			int displayNumber = Integer.parseInt(displayShow1);
			System.out.println("Now texting" + bs.list.getTheList().get(displayNumber).getName() + " at the address " + bs.list.getTheList().get(displayNumber).getStreetName());
		} catch (Exception e) {
			System.out.println("Please enter a valid number");
		}
	
	}
	
	public static void emailContact(BusinessService bs) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Please enter the number in the list you would like to email");
		String displayShow1 = kb.nextLine();
		try {
			int displayNumber = Integer.parseInt(displayShow1);
			System.out.println("Now texting" + bs.list.getTheList().get(displayNumber).getName() + " at the email " + bs.list.getTheList().get(displayNumber).getEmail());
		} catch (Exception e) {
			System.out.println("Please enter a valid number");
		}
	}
	
	public static void textContact(BusinessService bs) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Please enter the number you would like to text");
		String displayShow1 = kb.nextLine();
		try {
			int displayNumber = Integer.parseInt(displayShow1);
			System.out.println("Now texting" + bs.list.getTheList().get(displayNumber).getName() + " at the number " + bs.list.getTheList().get(displayNumber).getPhoneNumber());
		} catch (Exception e) {
			System.out.println("Please enter a valid number");
		}
	}

	public static void callContact(BusinessService bs) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Please enter the number you would like to call");
		String displayShow1 = kb.nextLine();
		try {
			int displayNumber = Integer.parseInt(displayShow1);
			System.out.println("Now calling " + bs.list.getTheList().get(displayNumber).getName());
		} catch (Exception e) {
			System.out.println("Please enter a valid number");
		}
	}

	public static void showOne(BusinessService bs) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Please enter the number you would like to display");
		String displayShow1 = kb.nextLine();
		try {
			int displayNumber = Integer.parseInt(displayShow1);
			System.out.println(bs.list.getTheList().get(displayNumber));
		} catch (Exception e) {
			System.out.println("Please enter a valid number");
		}
	}

	public static void showAll(BusinessService bs) {
		int count = 1;
		for (int i = 0; i < bs.list.getTheList().size(); i++) {
			System.out.println(count + " " + bs.list.getTheList().get(i));
			count++;
		}
	}

	public static void setUpData(BusinessService bs) {
		Boolean[] days = { false, true, true, true, true, true, false };

		BaseContact NV = new PersonContact("Noah Vandervelden", "2847 E 7th Street", "Kansas City", "MO", "64124", "US",
				"816-756-4005", "noah.vandy@gmail.com", "myphoto.jpg", "Me", "10-14-1999", "This is my own contact");
		bs.list.addOne(NV);

		BaseContact GCU = new BusinessContact("Grand Canyon University", "3300 West Camelback Road", "Pheonix", "AZ",
				"85017", "US", "1-800-4123", "Gcu@gcu.edu", "gcu.jpg", "Christian college in pheonix arizona", "7:00am",
				"9:00pm", days, "gcu.com");
		bs.list.addOne(GCU);

		BaseContact BW = new PersonContact("Blake Wilson", "5000 Whispering Oaks ln", "Smithville", "MO", "64125", "US",
				"816-213-1235", "blakewilson@gmail.com", "contactpic.jpg", "Friend", "05-22-2000",
				"This is my roommate Blake");
		bs.list.addOne(BW);

		BaseContact CP = new PersonContact("Caleb Pae", "1200 Half Cap rd", "Kansas City", "MO", "64124", "US",
				"815-829-2947", "cpae@gmail.com", "thatonepic.png", "Best Friend", "08-20-99", "Moved back to Italy");
		bs.list.addOne(CP);
		
		
		
	}

	public static void addNewPersonal(BusinessService bs) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter a name: ");
		String scanName = kb.nextLine();
		System.out.println("Enter the street: ");
		String scanStreet = kb.nextLine();
		System.out.println("Enter the city: ");
		String scanCity = kb.nextLine();
		System.out.println("Enter the State: ");
		String scanState = kb.nextLine();
		System.out.println("Enter the zipcode: ");
		String scanZip = kb.nextLine();
		System.out.println("Enter a country: ");
		String scanCountry = kb.nextLine();
		System.out.println("Enter a phone number: ");
		String scanNumber = kb.nextLine();
		System.out.println("Enter a photo name: ");
		String scanPhoto = kb.nextLine();
		System.out.println("Enter an email: ");
		String scanEmail = kb.nextLine();
		System.out.println("Enter your realtionship with this person: ");
		String scanRelationship = kb.nextLine();
		System.out.println("Enter a birthday: ");
		String scanBirthday = kb.nextLine();
		System.out.println("Enter a description: ");
		String scanDesc = kb.nextLine();

		// this is taking that information and shoving it into the contructor
		BaseContact contact1 = new PersonContact(scanName, scanStreet, scanCity, scanState, scanZip, scanCountry,
				scanNumber, scanEmail, scanPhoto, scanRelationship, scanBirthday, scanDesc);

		bs.list.addOne(contact1);

		System.out.println("Here is your new contact: ");
		System.out.println(bs.list.getTheList().get(bs.list.getTheList().size() - 1));
	}

	public static void addNewBusiness(BusinessService bs) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter a name: ");
		String scanName = kb.nextLine();
		System.out.println("Enter the street: ");
		String scanStreet = kb.nextLine();
		System.out.println("Enter the city: ");
		String scanCity = kb.nextLine();
		System.out.println("Enter the State: ");
		String scanState = kb.nextLine();
		System.out.println("Enter the zipcode: ");
		String scanZip = kb.nextLine();
		System.out.println("Enter a country: ");
		String scanCountry = kb.nextLine();
		System.out.println("Enter a phone number: ");
		String scanNumber = kb.nextLine();
		System.out.println("Enter a photo name: ");
		String scanPhoto = kb.nextLine();
		System.out.println("Enter an email: ");
		String scanEmail = kb.nextLine();
		System.out.println("Enter a description of the company: ");
		String scanDesc = kb.nextLine();
		System.out.println("Enter an opening time: ");
		String scanOpen = kb.nextLine();
		System.out.println("Enter a closing time: ");
		String scanClose = kb.nextLine();

		Boolean weekday = false;
		Boolean[] weekdayOpen = new Boolean[7];
		Map<Integer, String> weekMap = new HashMap<>();
		weekMap.put(0, "Sunday");
		weekMap.put(1, "Monday");
		weekMap.put(2, "Tuesday");
		weekMap.put(3, "Wednesday");
		weekMap.put(4, "Thursday");
		weekMap.put(5, "Friday");
		weekMap.put(6, "Saturday");

		for (int i = 0; i < 7; i++) {
			System.out.println("Answer 'Yes' if the company is open on " + weekMap.get(i));
			String dayOpen = kb.nextLine();
			if (dayOpen.equals("yes")) {
				weekday = true;
				weekdayOpen[i] = weekday;
			} else {
				weekday = false;
				weekdayOpen[i] = weekday;
			}
		}

		System.out.println("Enter a website URL: ");
		String scanURL = kb.nextLine();

		BaseContact newContact = new BusinessContact(scanName, scanStreet, scanCity, scanState, scanZip, scanCountry,
				scanNumber, scanPhoto, scanEmail, scanDesc, scanOpen, scanClose, weekdayOpen, scanURL);

		bs.list.addOne(newContact);
		System.out.println("Here is your new contact: ");
		System.out.println(bs.list.getTheList().get(bs.list.getTheList().size() - 1));
	}

	public static void editContact(BusinessService bs) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter the position you would like to display");
		int indexChoice = Integer.parseInt(kb.nextLine());
		if (indexChoice != -1) {
			System.out.println(bs.list.getTheList().get(indexChoice).getName() + " has been selected");
			System.out.println("Please enter what you would like to edit");
			String editChoice = kb.nextLine();
			switch (editChoice) {

			// THIS DOES NOT WORK. IT GIVES ME AN OUT OF BOUNDS EXCEPTION. I NEED HELP.
			case "Name":
				System.out.println("Please enter what you would like to change the name to");
				String newName = kb.nextLine();
				bs.list.getTheList().get(indexChoice).setName(newName);
				System.out.println(bs.list.getTheList().get(indexChoice).getName());
				break;
			case "Street":
				System.out.println("Please enter what you would like to change the street to");
				String newStreet = kb.nextLine();
				bs.list.getTheList().get(indexChoice).setStreetName(newStreet);
				break;
			case "City":
				System.out.println("Please enter what you would like to change the street to");
				String newCity = kb.nextLine();
				bs.list.getTheList().get(indexChoice).setStreetName(newCity);
				break;
			case "State":
				System.out.println("Please enter what you would like to change the street to");
				String newState = kb.nextLine();
				bs.list.getTheList().get(indexChoice).setStreetName(newState);
				break;
			case "Country":
				System.out.println("Please enter what you would like to change the street to");
				String newCountry = kb.nextLine();
				bs.list.getTheList().get(indexChoice).setStreetName(newCountry);
				break;
			case "Phone Number":
				System.out.println("Please enter what you would like to change the street to");
				String newNumber = kb.nextLine();
				bs.list.getTheList().get(indexChoice).setStreetName(newNumber);
				break;
			case "Photo Name":
				System.out.println("Please enter what you would like to change the street to");
				String newPhoto = kb.nextLine();
				bs.list.getTheList().get(indexChoice).setStreetName(newPhoto);
				break;
			case "Email":
				System.out.println("Please enter what you would like to change the street to");
				String newEmail = kb.nextLine();
				bs.list.getTheList().get(indexChoice).setStreetName(newEmail);
				break;
			}
		}
	}

	public static void deleteContact(BusinessService bs) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter the name you would like to delete.");
		String searchName = kb.nextLine();
		if (bs.list.searchFor(searchName) != -1) {
			System.out.println(bs.list.getTheList().get(bs.list.searchFor(searchName)).getName() + " has been deleted");
			bs.list.deleteOne(bs.list.getTheList().get(bs.list.searchFor(searchName)));

		} else {
			System.out.println("There is no contact found under " + searchName);
		}
	}

	public static void searchContact(BusinessService bs) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter what you would like to search for");
		String searchItem = kb.nextLine();
		for (int i = 0; i < bs.list.getTheList().size(); i++) {
			if (bs.list.searchFor(searchItem, i) != -1) {
				System.out.println(bs.list.getTheList().get(bs.list.searchFor(searchItem, i)));
			} else {
				System.out.println("No contacts were found");
			}
		}
	}

	public static void loadList(BusinessService bs) { 
		bs.list = bs.loadAllLists();
	}
}
