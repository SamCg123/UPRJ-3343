package libsystem;

import java.text.ParseException;

public class CmdBorrowBook implements CustomerCommand {

	BookList booklist = BookList.getInstance();
	
	@Override
	public void execute(String[] cmdParts, Customer customer ) throws Exception {

			booklist.Borrow_book(cmdParts[1]);

	}

}