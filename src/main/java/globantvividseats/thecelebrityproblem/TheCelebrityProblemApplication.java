package globantvividseats.thecelebrityproblem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import globantvividseats.thecelebrityproblem.base.PersonCollectionUtil;
import globantvividseats.thecelebrityproblem.model.Person;

@SpringBootApplication
@ShellComponent
public class TheCelebrityProblemApplication extends PersonCollectionUtil{
	
	private List<Person> allPersonList;
	
	public static final String messagePersonAdded="The Person was added";
	public static final String messageRelationAdded="The Relation was added";
	public static final String messagePersonNotExists="The Person Not Exists";
	public static final String messagePersonAlreadyExists="The Person already Exists";
	public static final String messageCelebrityFound="The Celebrity name is %s";
	public static final String messageCelebrityNotFound="The Celebrity is not here";

	public static void main(String[] args) {
		SpringApplication.run(TheCelebrityProblemApplication.class, args);
	}
	
	
	public TheCelebrityProblemApplication() {
		super();
		this.allPersonList = new ArrayList<Person>();
	}
	
	@ShellMethod("Add a new Person.")
    public String addPerson(@ShellOption(help = "This parameter is the name of the Person that will be added") String personName) {
		try {
			Person sourcePerson = getRelation(this.allPersonList,personName);
			if(sourcePerson!=null)
				throw new Exception(messagePersonAlreadyExists);
			Person person = new Person(personName.toUpperCase());
			this.allPersonList.add(person);
			return TheCelebrityProblemApplication.messagePersonAdded;
		}catch(Exception ee) {
			return ee.getMessage();
		}
    }
	
	@ShellMethod("Add a new Relation.")
    public String addRelation(	@ShellOption(help = "This parameter is the name of the Person who has the relation")  String sourcePersonName, 
    							@ShellOption(help = "This parameter is the name of the know Person") String targetPersonName) {
		try {
			Person sourcePerson = getRelation(this.allPersonList,sourcePersonName);
			if(sourcePerson==null)
				throw new Exception(messagePersonNotExists);
			Person targetPerson = getRelation(this.allPersonList,targetPersonName);
			if(targetPerson==null)
				throw new Exception(messagePersonNotExists);
			addRelation(sourcePerson,targetPerson);
			return TheCelebrityProblemApplication.messageRelationAdded;
		}catch(Exception ee) {
			return ee.getMessage();
		}
    }
	
	@ShellMethod("Find the Celebrity using the relations list recursively from source person. This approach just return one celebrity.")
    public String findCelebrityByRelations(	@ShellOption(help = "This parameter is the name of the Person from where I want start the search.")  String sourcePersonName) {
		try {
			Person sourcePerson = getRelation(this.allPersonList,sourcePersonName);
			if(sourcePerson==null)
				throw new Exception(messagePersonNotExists);
			HashSet<Person> verifiedPersonSet= new HashSet<Person>();
			Person celebrity = findCelebrityByRelations(sourcePerson,verifiedPersonSet,this.allPersonList);
			if(celebrity==null)
				throw new Exception(messageCelebrityNotFound);
			else return String.format(messageCelebrityFound, celebrity.getName());	
		}catch(Exception ee) {
			return ee.getMessage();
		}
    }
	
		
}
