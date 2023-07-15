package libsystem;
public class CmdReturnBook implements CustomerCommand {
	
	BookList bookList = BookList.getInstance();
	Customer customer;
	
	@Override
	public void execute(String[] cmdParts, Customer customer) {

			bookList.Return_book(cmdParts[1], customer.getId());

	}
}