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
		
		Person john = new Person("John", "000", "", "1234567890");
		Person sofie = new Person("Sofie", "001", "", "1234563456");
		Person jane = new Person("Jane", "002", "", "1234565670");
		Person alex = new Person("Alex", "005", "", "1234565670");
		Person roger = new Person("roger", "008", "", "1234565670");
		//set status
		john.setStatus(john.isSafe());
		sofie.setStatus(sofie.isSafe());
		jane.setStatus(jane.isSafe());
		alex.setStatus(alex.isSafe());
		roger.setStatus(roger.isSafe());
		
		//adds persons to tracer manager
		manager.addTracer(john);
		manager.addTracer(sofie);
		manager.addTracer(alex);
		manager.addTracer(roger);
		manager.addTracer(jane);
		
		Person newSofie = new Person("Sofie Taylor", "001", "is safe", "1234563708"); //new number for sofie and name
		manager.updateTracer(newSofie);	//update sofie with sofie taylor
		manager.removeTracer(newSofie);//removes sofie taylor
		manager.addTracer(jane);	//should return a printout already a tracer
		
		//Create Contacts for Person->Tracer objects
		manager.addContact(jane, john.getId());
		manager.addContact(john, jane.getId());
		manager.addContact(john, alex.getId());
		manager.addContact(john, roger.getId());
		manager.removeContact(john, jane.getId());
		manager.addTracer(manager.inputFromKeyboard());
		manager.writeToTerminal();
		
		//reads and writes from text files
		DataManager Filemanager = new DataManager();
		Filemanager.readFrom("input.txt");
		Filemanager.writeFile();

		
	}

}
