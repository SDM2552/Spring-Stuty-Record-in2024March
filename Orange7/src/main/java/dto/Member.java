package dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
	private int numId;
	private String id;
	private String pw;
	private String name;

	public Member() {
	}

	public Member(String id, String pw, String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
	}

	public Member(int numId, String id, String pw, String name) {
		super();
		this.numId = numId;
		this.id = id;
		this.pw = pw;
		this.name = name;
	}

//	public int getNumId() {
//		return numId;
//	}
//	public void setNumId(int numId) {
//		this.numId = numId;
//	}
//	public String getId() {
//		return id;
//	}
//	public void setId(String id) {
//		this.id = id;
//	}
//	public String getPw() {
//		return pw;
//	}
//	public void setPw(String pw) {
//		this.pw = pw;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}

	@Override
	public String toString() {
		return "Member [numId=" + numId + ", id=" + id + ", pw=" + pw + ", name=" + name + "]";
	}

}
