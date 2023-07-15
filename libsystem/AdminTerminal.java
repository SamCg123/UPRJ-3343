package libsystem;
import java.util.Scanner;

public class AdminTerminal {

	LMSystem system = LMSystem.getInstance();
	UserList userlist = UserList.getInstance();
	BookList booklist = BookList.getInstance();
	
	private Admin admin;
	private Customer customer;
	private String[] cmdParts = new String[100];
	static Scanner sc = new Scanner(System.in);
	
	
	public AdminTerminal(RoleType user) throws Exception{
		
		System.out.print("Please enter your instruction: ");
	    cmdParts[0] = sc.next();
//	    TimeUnit.SECONDS.sleep(20);
	    
		if (sc.hasNextLine()) {
			if (cmdParts[0].equals("addbook")){
				Add_book(cmdParts, admin);
				System.out.println("\nAdded book successfully!\n");
            }else if(cmdParts[0].equals("searchbookname")){
            	Search_book_name(cmdParts);
            }else if(cmdParts[0].equals("searchbookid")){
            	Search_book_id(cmdParts);
            }else if(cmdParts[0].equals("deletebook")){
            	Delete_book(cmdParts, admin);
            }else if(cmdParts[0].equals("manage")){
            	Manage_user(cmdParts, admin);
            }else if(cmdParts[0].equals("viewstat")) {
            	View_statistics();
            }else if(cmdParts[0].equals("save_reload")) {
            	Save(cmdParts);
            }else if(cmdParts[0].equals("logout")) {
            	system.logout();
            }else {
            	System.out.print("Please input the correct action!");
            }
            new AdminTerminal(user);   
		}
	}

	private void Manage_user(String[] cmdParts, Admin admin) {
		System.out.print("Please enter the field wanted to change: ");
		cmdParts[1] = sc.next();
		if(!(cmdParts[1].equals("Name")||cmdParts[1].equals("Password")||cmdParts[1].equals("Major")||cmdParts[1].equals("Role"))) {
			System.out.println("Undefined field!!");
		}else {
			System.out.print("Please enter the updated record: ");
			cmdParts[2] = sc.next();
			if(cmdParts[1].equals("Role")&&!(cmdParts[2].equals("A")||cmdParts[2].equals("S"))) {
				System.out.println("The role type must be \"A\" or \"S\"!");
			}else {
				System.out.print("Please enter the  Student id: ");
				cmdParts[3] = sc.next();
				(new CmdManageUser()).execute(cmdParts, admin);	
			}
		}
		
		
	}

	private void Delete_book(String[] cmdParts,  Admin admin) {
		System.out.print("Please enter the name of the book : ");
		cmdParts[1] = sc.next();
		(new CmdDeleteBook()).execute(cmdParts, admin);	
		
	}

	private void Add_book(String[] cmdParts, Admin admin) {
		System.out.print("Please enter the Title of book : ");
		cmdParts[1] = sc.next();
		System.out.print("Please enter the Author of book : ");
		cmdParts[2] = sc.next();
		System.out.print("Please enter the ID of book : ");
		cmdParts[3] = sc.next();
		System.out.print("Please enter the Category of book : ");
		cmdParts[4] = sc.next();
		System.out.print("Please enter the Publisher of book : ");
		cmdParts[5] = sc.next();
//		System.out.print("Please enter the BorrowDate of add book : ");
		cmdParts[6] = "N/A";
//		System.out.print("Please enter the ReturnDate of add book : ");
		cmdParts[7] = "N/A";
		System.out.print("Please enter the PubblishDate of add book : ");
		cmdParts[8] = sc.next();
//		System.out.print("Please enter the BorrowTimes of add book : ");
		cmdParts[9] = "0";
//		System.out.print("Please enter the Borrower of add book : ");
		cmdParts[10] = "N/A";
		(new CmdAddBook()).execute(cmdParts, admin);	
		
	}

	public void Search_book_name(String[] cmdParts) throws Exception {
		System.out.print("Please enter the keyword of the book: ");
		cmdParts[1] = sc.next();
		(new CmdSearchBook()).execute(cmdParts, customer);	

	}
	
	public void Search_book_id(String[] cmdParts) throws Exception {
		
		System.out.print("Please enter the id of the book: ");
		cmdParts[1] = sc.next();
		(new CmdSearchBook()).execute2(cmdParts, customer);
	}

	public void View_statistics() {
		System.out.println("Please enter the number to choose which statistics to view: ");
		System.out.println("01 - Number of Members");
		System.out.println("02 - Number of Books");
		System.out.println("03 - Rank of Books");
//		System.out.println("04 - ");
		cmdParts[1] = sc.next();
		if(cmdParts[1].equals("01")) {
			int totalmenber = userlist.getTotalmember();
			System.out.printf("Number of Members: %d\n", totalmenber);
		}else if(cmdParts[1].equals("02")){
			int totalbook = booklist.getTotalBook();
			System.out.printf("Number of Books: %d\n",totalbook);
		}else if(cmdParts[1].equals("03")) {
			(new CmdViewBookRanking()).execute(cmdParts, customer);
		}else {
			System.out.print("Please enter the correct number.");
		}
	}
	
	public void Save(String[] cmdParts) throws Exception {
		System.out.print("System backup in progress...\n");
		booklist.exportBookList();
		userlist.exportUserList();
		
		System.out.print("System rebooting...\n");
		DataExtraction.extractBookList();
		DataExtraction.extractUserlist();
		system.login();
		
	}
	
	public RoleType Login(String id, String pw) {
		// TODO - implement AdminTerminal.Login
		throw new UnsupportedOperationException();
	}

	public void Logout() {
		// TODO - implement AdminTerminal.Logout
		throw new UnsupportedOperationException();
	}

	public void Forgot_password(String Id) {
		// TODO - implement AdminTerminal.Forgot_password
		throw new UnsupportedOperationException();
	}

}