package libsystem;

import java.text.ParseException;

public interface CustomerCommand {

	public void execute(String[] cmdParts, Customer customer) throws ParseException, Exception;

}