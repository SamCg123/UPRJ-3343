package libsystem;
public class CmdAddBook implements AdminCommand {

	BookList booklist = BookList.getInstance();
	
	@Override
	public void execute(String[] cmdParts, Admin admin) {

			booklist.addBook(new Book(cmdParts[1],cmdParts[2],cmdParts[3],cmdParts[4],cmdParts[5],cmdParts[6],cmdParts[7],cmdParts[8],cmdParts[9],cmdParts[10]));
	}

}