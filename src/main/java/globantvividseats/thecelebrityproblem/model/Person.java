package globantvividseats.thecelebrityproblem.model;

import java.util.ArrayList;
import java.util.List;

import globantvividseats.thecelebrityproblem.RelationExistsException;

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

	public void addRelation(Person person) throws RelationExistsException{
		if(!existsRelation(person)) {
			this.relationsList.add(person);
		}else {
			throw new RelationExistsException();
		}		
	}
	
	private boolean existsRelation(Person person) {
		boolean exists=false;
		for(Person personInList : this.relationsList) {
			if(personInList.equals(person)) {
				exists = true;
				break;
			}
		}
		return exists;
	}
	
	public Person getRelation(String personName) {
		Person person = new Person(personName.toUpperCase());
		for(Person personInList : this.relationsList) {
			if(personInList.equals(person)) {
				return personInList;
			}
		}
		return null;
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
	
	
	public Person findCelebrityByRelations() {
		if(this.relationsList.size()==0)
			return this;
		for(Person personInList: this.relationsList) {
			return personInList.findCelebrityByRelations();
		}
		return null;
	}
	
	
	
	

}
