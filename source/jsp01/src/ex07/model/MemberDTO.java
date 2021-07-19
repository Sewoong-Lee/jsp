package ex07.model;

public class MemberDTO {
	private String email;
	private String passwd;
	private String nicname;
	private String phone;
	private String addr;
	private String regdate;
	private String modifydate;
	
	public MemberDTO() {
		super();
	}

	
	public MemberDTO(String email, String passwd, String nicname, String phone, String addr) {
		super();
		this.email = email;
		this.passwd = passwd;
		this.nicname = nicname;
		this.phone = phone;
		this.addr = addr;
	}


	public MemberDTO(String email, String passwd, String nicname, String phone, String addr, String regdate,
			String modifydate) {
		super();
		this.email = email;
		this.passwd = passwd;
		this.nicname = nicname;
		this.phone = phone;
		this.addr = addr;
		this.regdate = regdate;
		this.modifydate = modifydate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getNicname() {
		return nicname;
	}

	public void setNicname(String nicname) {
		this.nicname = nicname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getModifydate() {
		return modifydate;
	}

	public void setModifydate(String modifydate) {
		this.modifydate = modifydate;
	}

	@Override
	public String toString() {
		return "MemberDTO [email=" + email + ", passwd=" + passwd + ", nicname=" + nicname + ", phone=" + phone
				+ ", addr=" + addr + ", regdate=" + regdate + ", modifydate=" + modifydate + "]";
	}
	
	
	
	
}
