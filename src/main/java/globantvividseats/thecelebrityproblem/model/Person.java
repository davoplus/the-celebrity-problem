package globantvividseats.thecelebrityproblem.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import globantvividseats.thecelebrityproblem.RelationExistsException;
import globantvividseats.thecelebrityproblem.base.PersonCollectionUtil;

/**
 * This class contain the basic object of this application
 * @author david.caicedo
 *
 */
public class Person {
	
	private String name;
	private List<Person> relationsList;
	
	
	
	/**
	 * Constructor of Person class
	 */
	public Person() {
		this.relationsList = new ArrayList<Person>();
	}
	
	/**
	 * Constructor of Person class
	 * @param name the name of the person
	 */
	public Person(String name) {
		this.relationsList = new ArrayList<Person>();
		this.name = name;
	}
	
	/**
	 * accessor method for name
	 * @return the name of the person
	 */
	public String getName() {
		return name;
	}
	/**
	 * accessor method for name
	 * @param name this param contains the name of the person
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	/**
	 * accessor method for the relations list
	 * @return the relation list
	 */
	public List<Person> getRelationsList() {
		return relationsList;
	}

	/**
	 * accessor method for relations list
	 * @param relationsList used to set the entire relations list
	 */
	public void setRelationsList(List<Person> relationsList) {
		this.relationsList = relationsList;
	}

			
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
	    int hash = 3;
	    hash = 53 * hash + (this.name != null ? this.name.hashCode() : 0);
	    return hash;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
	    return this.getName();
	}

}
