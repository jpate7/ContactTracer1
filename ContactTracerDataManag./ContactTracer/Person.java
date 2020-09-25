/**
 * 
 */
package ContactTracer;

import java.util.Iterator;
import java.lang.Object;
import java.io.*; 
import java.util.*;

public class Person {
	private String name;
	private String id;
	private String phone;
	private int count;
	private ArrayList<String> contactID;
	private String status;
	
	
	public Person() {
		name = "not set";
		id = "not set";
		status = "not set";
		phone = "not set";
		count = 0;
		contactID = new ArrayList<String>();
	}
	
	public Person(String idNum)
	{
		this();
		id = idNum;
	}
	
	public Person(String n, String i, String s, String number) 
	{
		name = n;
		id = i;
		status = s;
		phone = number;
		count = 0;
		contactID = new ArrayList<String>();

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

	public void addContactID(String id)
	{
		contactID.add(id);
		count++;	
	}
	public void removeContactID(String id)
	{
		contactID.remove(id);
		contactID.trimToSize();
		count--;
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
		return new ArrayListIterator<String>(contactID, count);
	}
	// string representation of this person
	public String toString () 
	{
		String toReturn = "ID: " + id +";"+"Name: " + name +";" + "Status: " + status + ";" + "Phone #: " + phone + ";" + "ID of Contacts: [";
		
		while(this.Iterator().hasNext())
		{
			toReturn += this.Iterator().next();
		}
		toReturn += "]";
	
		return toReturn;
	}
}
