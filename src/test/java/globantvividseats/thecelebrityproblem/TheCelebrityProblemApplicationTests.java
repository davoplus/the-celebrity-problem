package globantvividseats.thecelebrityproblem;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.Shell;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {
	    ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false",
	    InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false"
	})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TheCelebrityProblemApplicationTests {
	
	@Autowired
    private Shell shell;
	
	
	public TheCelebrityProblemApplicationTests() {
		super();		
	}

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testAddPerson()throws Exception{
		
		assertThat(shell.evaluate(() -> "add-person a")).isEqualTo(TheCelebrityProblemApplication.messagePersonAdded);
		assertThat(shell.evaluate(() -> "add-person b")).isEqualTo(TheCelebrityProblemApplication.messagePersonAdded);
		assertThat(shell.evaluate(() -> "add-person c")).isEqualTo(TheCelebrityProblemApplication.messagePersonAdded);
		assertThat(shell.evaluate(() -> "add-person d")).isEqualTo(TheCelebrityProblemApplication.messagePersonAdded);
		
	}
	
	@Test
	public void testAddRelations()throws Exception{
		
		assertThat(shell.evaluate(() -> "add-relation a b")).isEqualTo(TheCelebrityProblemApplication.messageRelationAdded);
		assertThat(shell.evaluate(() -> "add-relation b a")).isEqualTo(TheCelebrityProblemApplication.messageRelationAdded);
		assertThat(shell.evaluate(() -> "add-relation a c")).isEqualTo(TheCelebrityProblemApplication.messageRelationAdded);
		assertThat(shell.evaluate(() -> "add-relation a d")).isEqualTo(TheCelebrityProblemApplication.messageRelationAdded);
		assertThat(shell.evaluate(() -> "add-relation b c")).isEqualTo(TheCelebrityProblemApplication.messageRelationAdded);
		assertThat(shell.evaluate(() -> "add-relation b d")).isEqualTo(TheCelebrityProblemApplication.messageRelationAdded);	
		assertThat(shell.evaluate(() -> "add-relation b d")).isEqualTo(RelationExistsException.message);
		
		
	}
	
	@Test
	public void testFindCelebrities()throws Exception{
		
		String [] celebritiesCandD = {"C","D"};		
		assertThat(shell.evaluate(() -> "find-celebrities")).isEqualTo(String.format(TheCelebrityProblemApplication.messageCelebrityFound, String.join(",", celebritiesCandD)));			
		
	}
	
	@Test
	public void testFindCelebrityByRelations()throws Exception{
	
		String celebrityC = "C";
		assertThat(shell.evaluate(() -> "find-celebrity-by-relations a")).isEqualTo(String.format(TheCelebrityProblemApplication.messageCelebrityFound, celebrityC));			
		
	}
	
	@Test
	public void testFindCelebritiesByRelations()throws Exception{
		
		String [] celebritiesCandD = {"C","D"};		
		assertThat(shell.evaluate(() -> "find-celebrities-by-relations a")).isEqualTo(String.format(TheCelebrityProblemApplication.messageCelebrityFound, String.join(",", celebritiesCandD)));			
		
	}

}
