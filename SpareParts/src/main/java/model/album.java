package model;

public class album {
	
	private int id;
	private String name;
	private String parts;
	private String country;
	
	
	
	public album(int id, String name, String parts, String country) {
		super();
		this.id = id;
		this.name = name;
		this.parts = parts;
		this.country = country;
	}
	
	
	
	public album(String name, String parts, String country) {
		super();
		this.name = name;
		this.parts = parts;
		this.country = country;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getparts() {
		return parts;
	}
	public void setparts(String parts) {
		this.parts = parts;
	}
	
	public String getcountry() {
		return country;
	}
	public void setcountry(String country) {
		this.country = country;
	}

	

}
