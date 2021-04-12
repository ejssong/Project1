package JDBC;

public class MemberDTO {
	private String id;
	private String first_name;
	private String last_name;
	private String tel;
	private String password;
	private String car;
	

	public MemberDTO(String id, String first_name, String last_name, String tel, String password, String car) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.tel = tel;
		this.password = password;
		this.car = car;
	}

	public MemberDTO(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public MemberDTO(String id) {
		this.id = id;
	}
	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", tel=" + tel
				+ ", password=" + password + ", car=" + car + "]";
	}
	
	
}
