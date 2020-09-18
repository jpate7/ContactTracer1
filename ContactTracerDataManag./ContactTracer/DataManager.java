/**
 * 
 */
package ContactTracer;

import java.util.Iterator;


public class DataManager
{
	private final int MAX_TRACERS = 26;
	private Person tracers[];
	private int count;
	
	public DataManager()
	{ 
		tracers = new Person[MAX_TRACERS];
		count = 0;
	}
	
	public void addTracer(Person P)
	{//add person as a tracer, who's status is at risk or higher, and must notify his contacts
		
		if(count >= MAX_TRACERS)	//if array is full, extend size
		{
			Person[] newArray = new Person[MAX_TRACERS * 2];
			Iterator<Person> iter = Iterator();
			int i = 0;
			while(iter.hasNext())
			{
				newArray[i] = iter.next();	//copy references from current array to new array
				i++;
			}
			tracers = newArray;		//reassign reference to new array
		}
		tracers[count] = P;			//add Person to tracers
		count++;					//increment count
		
	}
	
	public void addContact(Person P, Person C)	
	{//add Person C(contact) into the contact array collection stored in Person P(tracer)
		
		if(findPerson(P.getId()))
		{
			Iterator<Person> contact = P.Iterator();	//Cycle through Contacts in Person P
			while(contact.hasNext())
			{
				if(!(containsContact(P, C)))
				{
					
				}
			}
		}
		else
			System.out.println("Person is not a contact tracer");
	}
	
	
	public boolean containsContact(Person P, Person C)
	{//returns true if Contact C is in Person P's collection
		
		return false;
	}
	
	public boolean findPerson(String id)
	{
		//finds the person with id from tracers using a Iterator
		
		return false;
	}
	public Iterator<Person> Iterator()
	{
		//initialize a new iterator to cycle Person contacts
		return new ObjectIterator<Person>(tracers, count);
	}
}
