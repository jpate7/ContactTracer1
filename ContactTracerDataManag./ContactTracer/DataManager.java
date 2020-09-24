
package ContactTracer;

import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class DataManager
{
	//private final int MAX_TRACERS = 26;
	private Map<String, Person> tracers;	//Key: String ID	Value: Person references
	
	public DataManager()
	{ 
		tracers = new HashMap<String, Person>();
	}
	
	//--------------------------------METHODS START HERE-------------------------------------------
	
	public void addTracer(Person P)
	{//add person as a tracer, who's status is at risk or higher, and must notify his contacts
		if(tracers.containsKey(P.getId()))
			System.out.println(P.getId() +" Already is a tracer");
		//if tracer has Hash Key equal to Person P's ID, cannot add, instead update
		else
			tracers.put(P.getId(), P);	//add Person P to tracers
										//Person P's ID as HashKey 
										//Person P reference as Hash value
	}
	
	//---------------------------------------------------------------------------------------------
	
	public void updateTracer(Person P)
	{//privately update information on a tracer
		
		if(tracers.containsKey(P.getId()))
			tracers.replace(P.getId(), P);
		else
			System.out.println("Cannot update, Person is not a tracer");
	}
	
	//---------------------------------------------------------------------------------------------
	
	public boolean containsTracer(Person P)
	{//returns true if Person P is present in the HashMap tracer
		
		if(tracers.containsValue(P))	//if P is a tracer
			return true;
		
		return false;	//if P is not a tracer
		
	}
	
	//---------------------------------------------------------------------------------------------
	
	public boolean containsContact(Person P, String C)
	{//returns true if Contact C's ID is in Person P's contact collection
		Iterator<String> iter = P.Iterator();
		while(iter.hasNext())
		{
			if(iter.next().equals(C))	//if Person P's ID collection contains Person C's ID
					return true;
		}
		
		return false;
	}
	
	//--------------------------------------------------------------------------------------------
	
	
	public void addContact(Person P, String C)	
	{//add Person C(contact) id into the contact array collection stored in Person P(tracer)
		
		if(tracers.containsValue(P) && !(containsContact(P,C)))	//if tracers has Person P and P does not contain C already
		{
			P.addContactID(C);		//add Person C's id to Person P's ID collection
		}
		else
			System.out.println("Person is not a contact tracer or contact is already included!");
	}
	
	//----------------------------------------------------------------------------------------
	
	public void removeTracer(Person P)
	{//removes Person P from tracer if present
		
		if(tracers.containsValue(P))
			tracers.remove(P.getId(), P);
		else
			System.out.println("Person is not a tracer, cannot remove!");
	}
	
	//------------------------------------------------------------------------------------------
	

	public Person findPerson(String id)
	{//finds the person with id from tracers
		if(tracers.containsKey(id))
			return tracers.get(id);	//returns Person that has the parameter(id) as its key
		
		System.out.println("Person is not a tracer, returning a null reference ");
		return null;
	}
	
	
	//---------------------------------------------------------------------------------------------
	
	public void writeToTerminal()
	{//outputs all the relevent informations stored in the current(this) DataManger(HashMap)
		for(String keyId: tracers.keySet())	//iterate over the key-value pairs(ID-Person pair)
		{
			System.out.print("ID: " + tracers.get(keyId).getId()+"; ");
			System.out.print("Name: " + tracers.get(keyId).getName()+"; ");
			System.out.print("Phone #: " +tracers.get(keyId).getNumber()+"; ");
			System.out.print("Status: " + tracers.get(keyId).getStatus()+"; ");
			
			System.out.print("ID of Contacts: [" );
			Iterator<String> iter = tracers.get(keyId).Iterator();	//iterate over the contact's IDs
			while(iter.hasNext())
			{
				System.out.print(iter.next()+ ", ");	//print Person's contact's IDs
			}
			System.out.print("]\n");
		}
		
	}
	
	//-----------------------------------------------------------------------------------------------
	public void inputFromKeyboard()
	{//input a person object's data attributes from keyboard input
		Scanner scan = new Scanner(System.in);
		Person anotherPerson = new Person();
		String temp = new String();
		
		//ask for person info
		
		//ask for person id
		do
		{
			System.out.print("Please input a three digit person's ID: ");
			temp = scan.next();
		}while(tracers.containsKey(temp) || Integer.parseInt(temp) < 0);
		anotherPerson.setId(temp);
		//ask for person name
		System.out.print("Please input the name of person: ");
		temp = scan.nextLine();
		anotherPerson.setName(temp);
		//ask for person's current status
		
		
		/*
		String[] data = line.split(",");
		addTracer(new Person(data[1], data[0], data[2], data[3])); // 1- id;
																	//0 - Name; 
																	//2-Type; 
																	//3-PhoneNumber
		
		for(int i = 4; i < data.length; i++)
		{
			addContact(findPerson(data[0]), new String(data[i]));		// i - contact ids & 0 - tracer id
			*/
	}
	
	//----------------------------------------------------------------------------------------
	
	public void writeFile() {
		// overloaded method: this calls doWrite with different file name 
		// use this for testing write
		doWrite("output.txt");		
	}// end of writeFile method
	
	//-----------------------------------------------------------------------------------------
	
	private void doWrite(String fn) {
		// this method writes all of the data in the persons array to a file
		try
		{

			FileWriter fw = new FileWriter(fn);
			BufferedWriter myOutfile = new BufferedWriter(fw);	
			for(String keyId: tracers.keySet())	//iterate over the key-value pairs(ID-Person pair)
			{
				myOutfile.write("ID: " + tracers.get(keyId).getId()+"; ");
				myOutfile.write("Name: " + tracers.get(keyId).getName()+"; ");
				myOutfile.write("Phone #: " +tracers.get(keyId).getNumber()+"; ");
				myOutfile.write("Status: " + tracers.get(keyId).getStatus()+"; ");
				
				myOutfile.write("ID of Contacts: [" );
				Iterator<String> iter = tracers.get(keyId).Iterator();	//iterate over the contact's IDs
				while(iter.hasNext())
				{
					myOutfile.write(iter.next()+ ", ");	//print Person's contact's IDs
				}
				myOutfile.write("]\n");
			}
			
			myOutfile.flush();		//delete anything left in the buffer
			myOutfile.close();	//finished writing and close write file
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			System.err.println("Didn't save to " + fn);
		}
		
	}
	//----------------------------------------------------------------------------------------------------------
	
	public void readFrom(String file)
	{
		readFile(file);
	}

	private void readFile(String fileName) {
		BufferedReader lineReader = null;
		try {
			FileReader fr = new FileReader(fileName);
			lineReader = new BufferedReader(fr);
			String line = null;
			while ((line = lineReader.readLine())!=null)
			{
				String[] data = line.split(",");
				addTracer(new Person(data[1], data[0], data[2], data[3])); // 1- id;
																			//0 - Name; 
																			//2-Type; 
																			//3-PhoneNumber
				
				for(int i = 4; i < data.length; i++)
				{
					addContact(findPerson(data[0]), new String(data[i]));		// i - contact ids & 0 - tracer id
					
				}
				
			}
		} catch (Exception e) {
			System.err.println("there was a problem with the file reader, try different read type.");
			try {
				lineReader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(fileName.substring(1))));
				String line = null;
				while ((line = lineReader.readLine())!=null) 
				{
					String[] data = line.split(",");
					addTracer(new Person(data[1], data[0], data[2], data[3])); // 1- id;
																				//0 - Name; 
																				//2-Type; 
																				//3-PhoneNumber
					
					for(int i = 4; i < data.length; i++)
					{
						addContact(findPerson(data[0]), new String(data[i]));		// i - contact ids & 0 - tracer id
						
					}
				}
			} catch (Exception e2) {
				System.err.println("there was a problem with the file reader, try again.  either no such file or format error");
			} finally {
				if (lineReader != null)
					try {
						lineReader.close();
					} catch (IOException e2) {
						System.err.println("could not close BufferedReader");
					}
			}			
		} finally {
			if (lineReader != null)
				try {
					lineReader.close();
				} catch (IOException e) {
					System.err.println("could not close BufferedReader");
				}
		}
	} // end of readFile method

	//---------------------------------------------------------------------------------------------------------------------
}

