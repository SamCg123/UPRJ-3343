package libsystem;
public class CmdDeleteBook implements AdminCommand {
	
	BookList booklist = BookList.getInstance();
	
	@Override
	public void execute(String[] cmdParts, Admin admin) {

		booklist.Delete_book(cmdParts[1]);
	}

}