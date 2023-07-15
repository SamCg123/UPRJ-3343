package libsystem;
public class Customer implements RoleType {

	private String Id;
	private String Password;
	private String Name;
	private String Major;
	private String Role;
	private String Maxborrow;
	
	public Customer(String Id, String Password, String Name, String Major, String Role, String Maxborrow) {
		this.Id = Id;
		this.Password  = Password;
		this.Name      = Name;
		this.Major     = Major;
		this.Role      = Role;
		this.Maxborrow = Maxborrow;
	}

	public void Edit(String field, String info) {
		switch (field) {
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


	public void setStudentId(String id) {
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


	public String getMajor() {
		return Major;
	}


	public void setMajor(String major) {
		Major = major;
	}


	public String getRole() {
		return Role;
	}


	public void setRole(String role) {
		Role = role;
	}

	public String getMaxborrow() {
		return Maxborrow;
	}

	public void setMaxborrow(String maxborrow) {
		Maxborrow = maxborrow;
	}
	
	
	
}