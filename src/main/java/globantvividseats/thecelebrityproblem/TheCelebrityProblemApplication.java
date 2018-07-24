package globantvividseats.thecelebrityproblem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@SpringBootApplication
@ShellComponent
public class TheCelebrityProblemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheCelebrityProblemApplication.class, args);
	}
	
	@ShellMethod("Add a new Person.")
    public int addPerson(String personName) {
        return 1;
    }
}
