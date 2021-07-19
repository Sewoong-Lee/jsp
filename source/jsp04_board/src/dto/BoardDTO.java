package dto;

public class BoardDTO {
	private int bnum;
	private String userid;
	private String subject;
	private String content;
	private int readcount;
	private String ip;
	private int ref;
	private int restep;
	private int relevel;
	private String regdate;
	private String modifydate;
	
	public BoardDTO() {
		super();
	}
	

	public BoardDTO(String userid, String subject, String content, String ip, int ref, int restep, int relevel) {
		super();
		this.userid = userid;
		this.subject = subject;
		this.content = content;
		this.ip = ip;
		this.ref = ref;
		this.restep = restep;
		this.relevel = relevel;
	}

	public BoardDTO(int bnum, String userid, String subject, String content, int readcount, String ip, int ref,
			int restep, int relevel, String regdate, String modifydate) {
		super();
		this.bnum = bnum;
		this.userid = userid;
		this.subject = subject;
		this.content = content;
		this.readcount = readcount;
		this.ip = ip;
		this.ref = ref;
		this.restep = restep;
		this.relevel = relevel;
		this.regdate = regdate;
		this.modifydate = modifydate;
	}

	public int getBnum() {
		return bnum;
	}

	public void setBnum(int bnum) {
		this.bnum = bnum;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getRestep() {
		return restep;
	}

	public void setRestep(int restep) {
		this.restep = restep;
	}

	public int getRelevel() {
		return relevel;
	}

	public void setRelevel(int relevel) {
		this.relevel = relevel;
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
		return "BoardDTO [bnum=" + bnum + ", userid=" + userid + ", subject=" + subject + ", content=" + content
				+ ", readcount=" + readcount + ", ip=" + ip + ", ref=" + ref + ", restep=" + restep + ", relevel="
				+ relevel + ", regdate=" + regdate + ", modifydate=" + modifydate + "]";
	}
	
	
	
	
}
