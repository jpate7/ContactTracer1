/**
 * 
 */
package ContactTracer;

import java.util.Iterator;

public class Person {
	public static final int MAX_CONTACTS = 25;
	private String name;
	private String id;
	private String type;
	private String phone;
	private int count;
	private String[] contactID;
	private String status;
	
	
	public Person() {
		name = "not set";
		id = "not set";
		type = "not set";
		phone = "not set";
		count = 0;
		contactID = new String[MAX_CONTACTS];
	}
	
	public Person(String n, String i, String t, String number) 
	{
		name = n;
		id = i;
		type = t;
		phone = number;
		count = 0;
		contactID = new String[MAX_CONTACTS];

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
	public int getContactSize()
	{
		return count;
	}
	public void extendContactSize()
	{
		Iterator<String> iter = Iterator();
		String[] newArray = new String[Person.MAX_CONTACTS * 2];
		int i = 0;
		while(iter.hasNext())
		{
			newArray[i] = iter.next();
			i++;
		}
		contactID = newArray;
	}
	
	public void addContactID(String id)
	{
		contactID[count] = id;
		count++;	
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
	
	public Iterator<String> Iterator()
	{
		//initialize a new iterator to cycle Person contacts
		return new ObjectIterator<String>(contactID, count);
	}
	
	// string representation of this person
	public String toString () 
	{
		return name+"("+id+")" + ", " + "type: " + type+", " + "status: " + status+", " + "Phone #: " + phone;
	}
}
