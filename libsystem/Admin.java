package libsystem;
public class Admin implements RoleType {

	private String Id;
	private String Password;
	private String Name;
	private String Role;
	private String Major;


	public Admin(String Id, String Password, String Name, String Major, String Role) {
		this.Id   = Id;
		this.Password  = Password;
		this.Name      = Name;
		this.Major     = Major;
		this.Role      = Role;
		
	}

	public void Edit(String field, String info) {
		switch (field) {
			case "Id":
				setId(info);
				break;
			case "Password":
				setPassword(info);
				break;
			case "Name":
				setName(info);
				break;
			case "Major":
				setMajor(info);
				break;
			case "Role":
				setRole(info);
				break;		
		}
	}
	

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public String getMajor() {
		return Major;
	}

	public void setMajor(String major) {
		Major = major;
	}

}