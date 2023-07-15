package libsystem;
import java.util.*;

public class LMSystem {

	private static LMSystem instance = new LMSystem();
	UserList userlist = UserList.getInstance();
	public static LMSystem getInstance() {return instance;}
	
	private static Scanner sc = new Scanner(System.in);
	
	public static String id;
	public static void login() throws Exception {
	    
        System.out.print("\n\n[Login]");
		System.out.print("\nAccount id: ");
		id = sc.next();
		setId(id);
		System.out.print("Account Password: ");
		String pw = sc.next();
        
		
        RoleType user = verifyLogin(id,pw);
        
        if(user != null) {
    		if (user.getRole().equals("A")) {
    			System.out.println("Login Successfully!\nWelcome, "+ user.getName()+" !\n");
    			new AdminTerminal(user);
    		}else if(user.getRole().equals("S")){
    			 System.out.println("Login Successfully!\nWelcome, "+ user.getName()+" !\n");
                new CustomerTerminal(user);
    		} 
        }else {
        	System.out.println("\nLogin Fail! Wrong account name or password.");
        	login();
        }

        
	}

    public static RoleType verifyLogin(String id, String pw){
	    ArrayList<Admin> alist = UserList.getAdminList();
	    ArrayList<Customer> clist = UserList.getCustomerList();
	    for (RoleType r : alist){
	        if (r.getId().equals(id)){
	            if (r.getPassword().equals(pw)){
	                return r;
	            }
	        }
	    }
	    for (RoleType r : clist){
	        if (r.getId().equals(id)){
	            if (r.getPassword().equals(pw)){
	                return r;
	            }
	        }
	    }
	    return null;
	}
    
	public static void logout()throws Exception  {
		login();
	}
	
    public static void main(String args[]) throws Exception {
        
        LMSystem lm = LMSystem.getInstance();
        UserList list = UserList.getInstance();
        BookList blist = BookList.getInstance();

    	DataExtraction.extractBookList();
    	DataExtraction.extractUserlist();
        
 
//        lm.register();

        lm.login();

//        blist.printBookList();
//
//        list.printUserList();
        
        
        
    }

	public static String getId() {
		return id;
	}

	public static void setId(String id) {
		LMSystem.id = id;
	}
	
}