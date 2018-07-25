package globantvividseats.thecelebrityproblem.base;

import java.util.HashSet;
import java.util.List;

import globantvividseats.thecelebrityproblem.RelationExistsException;
import globantvividseats.thecelebrityproblem.model.Person;

/**
 * Utilitary class that wrap the core logic for Person collections
 * @author david.caicedo
 *
 */
public abstract class PersonCollectionUtil {
	
	/**
	 * This method add a new relation in source person
	 * @param sourcePerson the person to add the relation
	 * @param targetPerson the person who source knows
	 * @throws RelationExistsException
	 */
	public void addRelation(Person sourcePerson,Person targetPerson) throws RelationExistsException{
		if(!existsRelation(sourcePerson,targetPerson)) {
			sourcePerson.getRelationsList().add(targetPerson);
		}else {
			throw new RelationExistsException();
		}		
	}
	
	/**
	 * This method verify if exists a relation in source person that contains target person
	 * @param sourcePerson the owner of the relation
	 * @param targetPerson the person who source knows
	 * @return true if the relation exists
	 */
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
	
	/**
	 * This method return a object Person if the relation exists
	 * @param relationsList the list of relations of one Person
	 * @param personName the name of the person to validate
	 * @return
	 */
	public Person getRelation(List<Person> relationsList,String personName) {
		Person person = new Person(personName.toUpperCase());
		for(Person personInList : relationsList) {
			if(personInList.equals(person)) {
				return personInList;
			}
		}
		return null;
	}
	
	/**
	 * this is a recursive method that find and validate if a relation of source person is a celebrity
	 * @param sourcePerson the person to be validated
	 * @param verifiedPersonSet control list for avoid the infinite loop
	 * @param allPersonList the list with all person
	 * @return the person that is a celebrity
	 */
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
	
		
	/**
	 * This method validate if the person is known for all others person
	 * @param person this is the person to be validate
	 * @param allPersonList the list with all person
	 * @return
	 */
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
