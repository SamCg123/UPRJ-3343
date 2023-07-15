package libsystem;
public class CmdViewBookRanking implements CustomerCommand {

	BookList booklist = BookList.getInstance();
	
	@Override
	public void execute(String[] cmdParts, Customer customer) {
		booklist.View_bookRanking();
	}

}