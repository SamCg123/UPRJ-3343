package libsystem;
public interface AdminControl {

	public void View_statistics();

	public void Add_book(String[] cmdParts, Admin admin);

	public void Delete_book(String[] cmdParts, Admin admin);

	public void Manage_user(String[] cmdParts, Admin admin);

	public void Search_book();

	public RoleType Login(String id, String pw);

	public void Logout();

	public void Forgot_password(String Id);

}