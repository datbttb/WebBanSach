package Model;

public class Sach {
	private int id;
	private String name;
	private String img;
	private int price;
	private String title;
	private String description;
	private int cateID;
	
	
	public int getCateID() {
		return cateID;
	}

	public void setCateID(int cateID) {
		this.cateID = cateID;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Sach() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
//id  int(3) NOT NULL AUTO_INCREMENT,
//name varchar(120) NOT NULL,
//image varchar(250),
//price int,
//title varchar(250),
//description varchar(250),
//cateID int,