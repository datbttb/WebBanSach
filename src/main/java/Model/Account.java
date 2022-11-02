package Model;

public class Account {
	private int id;
	private String user;
	private String pass;
	private String name;
	private String email;
	private String country;
	private int isad;
	
	public Account() {
		super();  
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getIsad() {
		return isad;
	}

	public void setIsad(int isad) {
		this.isad = isad;
	}
	
	
	
}
