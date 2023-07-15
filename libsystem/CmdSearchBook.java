package libsystem;
//import java.lang.*;
import java.text.ParseException;

public class CmdSearchBook implements CustomerCommand {


	BookList bookList = BookList.getInstance();

	@Override
	public void execute(String[] cmdParts, Customer customer) throws ParseException 
	{
	        bookList.Search_book(cmdParts);
	}
	
	public void execute2(String[] cmdParts, Customer customer) throws ParseException 
	{
	        bookList.Search_bookByID(cmdParts);
	}
}