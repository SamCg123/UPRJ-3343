package libsystem;
public interface CustomerControl {

	public void Search_book(String[] cmdParts, Customer customer);

	public void Renew_book(String[] cmdParts, Customer customer);

	public void View_bookRanking(String[] cmdParts, Customer customer);

	public void Return_book(String Bookid, String Sid, Customer customer);

	public void Borrow_book(String[] cmdParts, Customer customer);

	public void Register(String id, String pw);

	public void Logout();

	public RoleType Login(String Id, String pw);

	public void Forgot_password(String Id);

}