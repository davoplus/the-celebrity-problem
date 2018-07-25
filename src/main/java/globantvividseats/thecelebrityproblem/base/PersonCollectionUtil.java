package globantvividseats.thecelebrityproblem.base;

import java.util.HashSet;
import java.util.List;

import globantvividseats.thecelebrityproblem.RelationExistsException;
import globantvividseats.thecelebrityproblem.model.Person;

public abstract class PersonCollectionUtil {
	
	public void addRelation(Person sourcePerson,Person targetPerson) throws RelationExistsException{
		if(!existsRelation(sourcePerson,targetPerson)) {
			sourcePerson.getRelationsList().add(targetPerson);
		}else {
			throw new RelationExistsException();
		}		
	}
	
	private boolean existsRelation(Person sourcePerson,Person targetPerson) {
		boolean exists=false;
		for(Person personInList : sourcePerson.getRelationsList()) {
			if(personInList.equals(targetPerson)) {
				exists = true;
				break;
			}
		}
		return exists;
	}
	
	public Person getRelation(List<Person> relationsList,String personName) {
		Person person = new Person(personName.toUpperCase());
		for(Person personInList : relationsList) {
			if(personInList.equals(person)) {
				return personInList;
			}
		}
		return null;
	}
	
	public Person findCelebrityByRelations(Person sourcePerson,HashSet<Person> verifiedPersonSet, List<Person> allPersonList) {
		if(!verifiedPersonSet.add(sourcePerson))
			return null;
		if(sourcePerson.getRelationsList().size()==0 && allKnowsMe(sourcePerson,allPersonList))
			return sourcePerson;
		Person celebrity=null;
		for(Person personInList: sourcePerson.getRelationsList()) {			
			celebrity = findCelebrityByRelations(personInList,verifiedPersonSet,allPersonList);
			if(celebrity!=null) {
				return celebrity;
			}
		}
		return null;
	}
	
	public void findCelebritiesByRelations(Person sourcePerson,HashSet<Person> celebritiesSet,HashSet<Person> verifiedPersonSet, List<Person> allPersonList) {
		if(!verifiedPersonSet.add(sourcePerson))
			return;
		
		if(sourcePerson.getRelationsList().size()==0 && allKnowsMe(sourcePerson,allPersonList)) {
			celebritiesSet.add(sourcePerson);
		}
		for(Person personInList: sourcePerson.getRelationsList()) {
			findCelebritiesByRelations(personInList,celebritiesSet,verifiedPersonSet,allPersonList);
		}		
		
	}
	
	public boolean allKnowsMe(Person person,List<Person> allPersonList) {
		boolean everyoneKnowsMe = true;
		for(Person personInList: allPersonList) {
			if(personInList.getRelationsList().size()==0 || personInList.equals(person)) {
				continue;
			}
			if(getRelation(personInList.getRelationsList(),person.getName()) == null){
				everyoneKnowsMe = false;
			}
		}
		return everyoneKnowsMe;
	}

}
