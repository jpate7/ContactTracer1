/**
 * 
 */
package ContactTracer;

/**
 * @author jakepatel
 *
 */
public class ProjectTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Create a new Hashmap Data Manager
		
		DataManager manager = new DataManager();
		Person john = new Person("John", "000", "student", "1234567890");
		Person sofie = new Person("Sofie", "001", "student", "1234563456");
		Person jane = new Person("Jane", "002", "student", "1234565670");
		john.setStatus(john.isSafe());
		sofie.setStatus(sofie.isSafe());
		jane.setStatus(jane.isSafe());
		manager.addTracer(john);
		manager.addTracer(sofie);
		manager.addTracer(jane);
		//Create Contacts for Person->Tracer objects
		manager.addContact(jane, john);
		manager.addContact(john, jane);
		
		manager.writeFile("output.txt");
		
	}

}
