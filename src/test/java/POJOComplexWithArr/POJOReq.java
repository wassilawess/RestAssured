package POJOComplexWithArr;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class POJOReq {
	
	String first;
	String last;
	String age;
	String id;
	POJOadr adr[];
	
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
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
	public POJOadr[] getAdr() {
		return adr;
	}
	public void setAdr(POJOadr[] adr) {
		this.adr = adr;
	}


}
