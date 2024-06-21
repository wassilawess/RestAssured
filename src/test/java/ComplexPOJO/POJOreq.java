package ComplexPOJO;

public class POJOreq {

	String firstname;
	String lastname;
	String age;
	String id;
	AdrPOJO Adress;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public AdrPOJO getAdress() {
		return Adress;
	}
	public void setAdress(AdrPOJO adress) {
		Adress = adress;
	}

}
