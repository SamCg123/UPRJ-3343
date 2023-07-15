package libsystem;
public class CmdRenewBook implements CustomerCommand {

	BookList bookList = BookList.getInstance();
	
	@Override
	public void execute(String[] cmdParts, Customer customer) throws Exception{
			
		bookList.Renew_book(cmdParts[1]);

	}
}

