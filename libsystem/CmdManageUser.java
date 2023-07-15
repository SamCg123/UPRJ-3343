package libsystem;
public class CmdManageUser implements AdminCommand {

	UserList userlist = UserList.getInstance();
	
	@Override
	public void execute(String[] cmdParts, Admin admin) {
        UserList.getInstance().manageUser(cmdParts[1], cmdParts[2], (cmdParts[3]));
	}
}