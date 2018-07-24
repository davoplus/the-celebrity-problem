package globantvividseats.thecelebrityproblem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import globantvividseats.thecelebrityproblem.model.Person;

@SpringBootApplication
@ShellComponent
public class TheCelebrityProblemApplication extends Person {
	
	public static final String messagePersonAdded="The Person was added";
	public static final String messageRelationAdded="The Relation was added";
	public static final String messagePersonNotExists="The Person Not Exists";
	public static final String messagePersonAlreadyExists="The Person already Exists";
	public static final String messageCelebrityFound="The Celebrity(ies) name(s) is(are) %s";
	public static final String messageCelebrityNotFound="The Celebrity is not here";

	public static void main(String[] args) {
		SpringApplication.run(TheCelebrityProblemApplication.class, args);
	}
	
	
	public TheCelebrityProblemApplication() {
		super();
	}
	
	@ShellMethod("Add a new Person.")
    public String addPerson(@ShellOption(help = "This parameter is the name of the Person that will be added") String personName) {
		try {
			Person sourcePerson = getRelation(personName);
			if(sourcePerson!=null)
				throw new Exception(messagePersonAlreadyExists);
			Person person = new Person(personName.toUpperCase());
			this.addRelation(person);
			return TheCelebrityProblemApplication.messagePersonAdded;
		}catch(Exception ee) {
			return ee.getMessage();
		}
    }
	
	@ShellMethod("Add a new Relation.")
    public String addRelation(	@ShellOption(help = "This parameter is the name of the Person who has the relation")  String sourcePersonName, 
    							@ShellOption(help = "This parameter is the name of the know Person") String targetPersonName) {
		try {
			Person sourcePerson = getRelation(sourcePersonName);
			if(sourcePerson==null)
				throw new Exception(messagePersonNotExists);
			Person targetPerson = getRelation(targetPersonName);
			if(targetPerson==null)
				throw new Exception(messagePersonNotExists);
			sourcePerson.addRelation(targetPerson);
			return TheCelebrityProblemApplication.messagePersonAdded;
		}catch(Exception ee) {
			return ee.getMessage();
		}
    }
	
	@ShellMethod("Find the Celebrity usin the relations list recursively. This approach just return 1 celebrity.")
    public String findCelebrityByRelations(	@ShellOption(help = "This parameter is the name of the Person from where I want start the search.")  String sourcePersonName) {
		try {
			Person sourcePerson = getRelation(sourcePersonName);
			if(sourcePerson==null)
				throw new Exception(messagePersonNotExists);
			Person celebrity = sourcePerson.findCelebrityByRelations();
			if(celebrity==null)
				throw new Exception(messageCelebrityNotFound);
			else return String.format(messageCelebrityFound, celebrity.getName());	
		}catch(Exception ee) {
			return ee.getMessage();
		}
    }
	
	@ShellMethod("Find the Celebrity usin the relations list of each Person added. This approach can return one or many celebrities.")
    public String findCelebrity() {
		try {
			List<Person> celebritiesList = new ArrayList<Person>();
			List<String> celebritiesNamesList = new ArrayList<String>();
			for(Person personInList: this.getRelationsList()) {
				if(personInList.getRelationsList().size()==0) {
					celebritiesNamesList.add(personInList.getName());
				}
			}
			if(celebritiesList.size()>0) {
				String [] celebrityNamesArray = new String [celebritiesNamesList.size()];
				celebrityNamesArray=celebritiesNamesList.toArray(celebrityNamesArray);
				return String.format(messageCelebrityFound, String.join(",", celebrityNamesArray));
			}else {
				throw new Exception(messageCelebrityNotFound);				
			}
				
		}catch(Exception ee) {
			return ee.getMessage();
		}
    }
	
}
