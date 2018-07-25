package globantvividseats.thecelebrityproblem.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import globantvividseats.thecelebrityproblem.RelationExistsException;
import globantvividseats.thecelebrityproblem.base.PersonCollectionUtil;

public class Person {
	
	private String name;
	private List<Person> relationsList;
	
	
	
	public Person() {
		this.relationsList = new ArrayList<Person>();
	}
	
	public Person(String name) {
		this.relationsList = new ArrayList<Person>();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public List<Person> getRelationsList() {
		return relationsList;
	}

	public void setRelationsList(List<Person> relationsList) {
		this.relationsList = relationsList;
	}

			
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
	        return false;
	    }
	    if (!Person.class.isAssignableFrom(obj.getClass())) {
	        return false;
	    }
	    final Person person = (Person) obj;
		return this.name!=null && person.getName() != null ? this.name.equals(person.getName()) : false;
	}
	
	
	@Override
	public int hashCode() {
	    int hash = 3;
	    hash = 53 * hash + (this.name != null ? this.name.hashCode() : 0);
	    return hash;
	}
	
	@Override
	public String toString() {
	    return this.getName();
	}

}
