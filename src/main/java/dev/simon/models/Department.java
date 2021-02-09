package dev.simon.models;

public class Department {
	
	private int id;
	private String name;
	private int dhId;
	
	public Department() {
		super();
	}
	
	public Department(int id, String name, int dhId) {
		super();
		this.id = id;
		this.name = name;
		this.dhId = dhId;
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

	public int getDhId() {
		return dhId;
	}

	public void setDhId(int dhId) {
		this.dhId = dhId;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", dhId=" + dhId + "]";
	}
	
	

}
