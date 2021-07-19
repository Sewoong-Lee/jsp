package ex09_guestbook;

public class GuestBookDTO {
	private int seq;
	private String nicname;
	private String email;
	private String content;
	private String regdate;
	
	public GuestBookDTO() {
		super();
	}

	public GuestBookDTO(int seq, String nicname, String email, String content, String regdate) {
		super();
		this.seq = seq;
		this.nicname = nicname;
		this.email = email;
		this.content = content;
		this.regdate = regdate;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getNicname() {
		return nicname;
	}

	public void setNicname(String nicname) {
		this.nicname = nicname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "GuestBookDTO [seq=" + seq + ", nicname=" + nicname + ", email=" + email + ", content=" + content
				+ ", regdate=" + regdate + "]";
	}
	
	
}
