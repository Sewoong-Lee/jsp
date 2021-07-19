package model;

public class MemberDTO {
	private String userid;
	private String passwd;
	private String salt;
	private String name;
	private String regdate;
	
	public MemberDTO() {
		super();
	}
	
	
	
	public MemberDTO(String userid, String passwd, String name) {
		super();
		this.userid = userid;
		this.passwd = passwd;
		this.name = name;
	}



	public MemberDTO(String userid, String passwd, String salt, String name) {
		super();
		this.userid = userid;
		this.passwd = passwd;
		this.salt = salt;
		this.name = name;
	}


	public MemberDTO(String userid, String passwd, String salt, String name, String regdate) {
		super();
		this.userid = userid;
		this.passwd = passwd;
		this.salt = salt;
		this.name = name;
		this.regdate = regdate;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "MemberDTO [userid=" + userid + ", passwd=" + passwd + ", salt=" + salt + ", name=" + name + ", regdate="
				+ regdate + "]";
	}
	
	
	
	
}
