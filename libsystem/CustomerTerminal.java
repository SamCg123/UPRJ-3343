package libsystem;
import java.text.ParseException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class CustomerTerminal {

	LMSystem system = LMSystem.getInstance();
	
	
	private Customer customer;
	private String[] cmdParts = new String[5];
	static Scanner sc = new Scanner(System.in);
	public CustomerTerminal(RoleType user) throws Exception {
//		String[] cmdParts = null;
//
//		while (!cmdParts[0].equals("exit")) {
//			Scanner sc = new Scanner(System.in);
//			String cmdLine = sc.nextLine().trim();
//			cmdParts = cmdLine.split("\\|");
//			
//			if (cmdParts[0].equals("searchBook"))
//				(new CmdSearchBook()).execute(cmdParts,(Customer)user);
//			if (cmdParts[0].equals("renewBook"))
//				(new CmdRenewBook()).execute(cmdParts,(Customer)user);
//			if (cmdParts[0].equals("returnBook"))
//				Return_book(cmdParts, customer);
//			if (cmdParts[0].equals("viewBookRanking"))
//				(new CmdViewBookRanking()).execute(cmdParts,(Customer)user);
//		}	

//		Scanner sc2 = new Scanner(System.in);
			System.out.print("Please enter your instruction: ");
		    cmdParts[0] = sc.next();
//		    TimeUnit.SECONDS.sleep(20);
		    
			if (sc.hasNextLine()) {
				if (cmdParts[0].equals("returnbook")){
					returnbook(cmdParts, user);
	            }else if(cmdParts[0].equals("searchbookname")){
	            	Search_book_name(cmdParts);
	            }else if(cmdParts[0].equals("searchbookid")){
	            	Search_book_id(cmdParts);
	            }else if(cmdParts[0].equals("borrow")){
	            	Borrow_book(cmdParts, customer);
	            }else if(cmdParts[0].equals("renew")){
	            	Renew_book(cmdParts, customer);
	            }else if(cmdParts[0].equals("viewrank")){
	            	View_bookRanking(cmdParts, customer);
	            }else if(cmdParts[0].equals("logout")) {
	            	system.logout();
	            }else {
	            	System.out.print("Please input the correct action!");
	            }
	            new CustomerTerminal(user);   
			}
		            
		            
//		            switch(cmdParts[0]) {
//		            	case("return"):
//		            		returnbook(cmdParts, user);
//		            		new CustomerTerminal(user);
//		            		break;
//		            	case("searchbookname"):
//		            		Search_book_name(cmdParts);
//		            		new CustomerTerminal(user);
//		            		break;
//		            	case("searchbookid"):
//		            		Search_book_id(cmdParts);
//		            		break;
//		            	case("borrow"):
//		            		Borrow_book(cmdParts, customer);
//		            		new CustomerTerminal(user);
//		            		break;
//		            	case("renew"):
//		            		Renew_book(cmdParts, customer);
//		            		new CustomerTerminal(user);
//		            		break;
//		            	case("viewRank"):
//		            		View_bookRanking(cmdParts, customer);
//		            		new CustomerTerminal(user);
//		            		break;
//		            	case("exit"):
//		            		system.logout();
//		            	default:
//		            		System.out.println("Please input the correct action!");
//		            		new CustomerTerminal(user);
//		            		break;
//			
// 
//            
//        }
		    
	}
        
        
        
//		if (!cmdParts[0].equals("exit")) {
//			if (cmdParts[0].equals("returnBook")){
//				returnbook(cmdParts, user);
//            }
//            //new CustomerTerminal(user);
//		}	
//		else{
//		    
//		}
//	    
//	}

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

	public void Renew_book(String[] cmdParts,Customer customer) throws Exception {
        System.out.print("Please enter the bookid: ");
        cmdParts[1] = sc.next();
        (new CmdRenewBook()).execute(cmdParts, customer);
	}

	public void View_bookRanking(String[] cmdParts,Customer customer) {
        (new CmdViewBookRanking()).execute(cmdParts, customer);
	}

//	public void Return_book(String[] cmdParts, Customer customer) {
//		control.Return_book(cmdParts[1], cmdParts[2], customer);
//	}
    public void returnbook(String[] cmdParts, RoleType user){
        System.out.print("Please enter the bookid: ");
        cmdParts[1] = sc.next();
        cmdParts[2] = user.getId();
        (new CmdReturnBook()).execute(cmdParts, (Customer)user);
        
    }

	public void Borrow_book(String[] cmdParts,Customer customer) throws Exception {
        System.out.print("Please enter the bookid: ");
        cmdParts[1] = sc.next();
        (new CmdBorrowBook()).execute(cmdParts, customer);
		
	}

	public void Register(String id, String pw) {
		// TODO - implement CustomerTerminal.Register
		throw new UnsupportedOperationException();
	}

	public void Logout() {
		// TODO - implement CustomerTerminal.Logout
		throw new UnsupportedOperationException();
	}

	public RoleType Login(String Id, String pw) {
		// TODO - implement CustomerTerminal.Login
		throw new UnsupportedOperationException();
	}

	public void Forgot_password(String Id) {
		// TODO - implement CustomerTerminal.Forgot_password
		throw new UnsupportedOperationException();
	}

}