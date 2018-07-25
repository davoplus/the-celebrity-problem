package globantvividseats.thecelebrityproblem;

public class RelationExistsException extends Exception {

	/**
	 * This exception cover the "The relation already exists" case
	 * @author david.caicedo
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String message= "The relation already exists";
	
	  public RelationExistsException() { super(RelationExistsException.message); }
	  public RelationExistsException(String message) { super(message); }
	  public RelationExistsException(String message, Throwable cause) { super(message, cause); }
	  public RelationExistsException(Throwable cause) { super(cause); }

}
