/**
 * 
 */
package ContactTracer;

import java.util.Iterator;

public class Person {
	private final int MAX_CONTACTS = 25;
	private String name;
	private String id;
	private String type;
	private String phone;
	private int count;
	private Person[] contacts;
	private String status;
	
	
	public Person() {
		name = "not set";
		id = "not set";
		type = "not set";
		phone = "not set";
		count = 0;
		contacts = new Person[MAX_CONTACTS];
	}
	
	public Person(String n, String i, String t, String number) 
	{
		name = n;
		id = i;
		type = t;
		phone = number;
		count = 0;
		contacts = new Person[MAX_CONTACTS];

	} 
	
	// getters and setters for private data
	public String getName() 
	{
		return name;
	}
	public void setName(String n) 
	{
		name = n;
	}
	public String getId() 
	{
		return id;
	}
	public void setId(String i) 
	{
		id = i;
	}	
	public String getType() 
	{
		return type;
	}
	public void setType(String t) 
	{
		type = t;
	}
	public void setStatus(String stat)
	{
		status = stat;
	}
	public String getStatus()
	{
		return status;
	}
	public String getNumber()
	{
		return phone;
	}
	public void setNumber(String number)
	{
		phone = number;
	}
	public int getSize()
	{
		return count;
	}

	public String isAtRisk()
	{
		return "At Risk";
	}
	public String isSafe()
	{
		return "Safe";
	}
	public String isInfected()
	{
		return "Infected";
	}
	public Iterator<Person> Iterator()
	{
		//initialize a new iterator to cycle Person contacts
		return new ObjectIterator<Person>(contacts, count);
	}
	
	// string representation of this person
	public String toString () 
	{
		return name+"("+id+")" + ", " + "type: " + type+", " + "status: " + status+", " + "Phone #: " + phone;
	}
}
