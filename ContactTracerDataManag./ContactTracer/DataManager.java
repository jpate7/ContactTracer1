/**
 * 
 */
package ContactTracer;

import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class DataManager
{
	//private final int MAX_TRACERS = 26;
	private Map<String, Person> tracers;	//Key: String ID	Value: Person references
	
	public DataManager()
	{ 
		tracers = new HashMap<String, Person>();
	}
	
	public void addTracer(Person P)
	{//add person as a tracer, who's status is at risk or higher, and must notify his contacts
		if(tracers.containsKey(P.getId()))
			System.out.println("Person is already a tracer, cannot add!");
		//if tracer has Hash Key equal to Person P's ID, cannot add, already a tracer
		else
			tracers.put(P.getId(), P);	//add Person P to tracers
										//Person P's ID as HashKey 
										//Person P reference as Hash value
	}
	
	public boolean containsContact(Person P, Person C)
	{//returns true if Contact C's ID is in Person P's contact collection
		Iterator<String> iter = P.Iterator();
		while(iter.hasNext())
		{
			if(iter.next().equals(C.getId()))	//if Person P's ID collection contains Person C's ID
					return true;
		}
		
		return false;
	}
	
	
	public void addContact(Person P, Person C)	
	{//add Person C(contact) into the contact array collection stored in Person P(tracer)
		
		if(tracers.containsValue(P) && !(containsContact(P,C)))	//if tracers has Person P and P does not contain C already
		{
			if(P.getContactSize() >= Person.MAX_CONTACTS)	//if Person P's ID collection is full
				P.extendContactSize();		//extend ID collection size 
			
			P.addContactID(C.getId());		//add Person C's id to Person P's ID collection
		}
		else
			System.out.println("Person is not a contact tracer, cannot add contact!");
	}
	

	public Person findPerson(String id)
	{
		//finds the person with id from tracers using a Iterator
		
		return new Person();
	}
	public Iterator<Person> Iterator()
	{
		//initialize a new iterator to cycle Person contacts
		return new ObjectIterator<Person>(tracers, count);
	}
}
