package model;

public class MonsterDTO {
	private String mcode;
	private String tcode;
	private String mname;
	private String tname;
	
	public MonsterDTO(String mcode, String tcode, String mname, String tname) {
		super();
		this.mcode = mcode;
		this.tcode = tcode;
		this.mname = mname;
		this.tname = tname;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public MonsterDTO() {
		super();
	}
	public MonsterDTO(String mcode, String tcode, String mname) {
		super();
		this.mcode = mcode;
		this.tcode = tcode;
		this.mname = mname;
	}
	public String getMcode() {
		return mcode;
	}
	public void setMcode(String mcode) {
		this.mcode = mcode;
	}
	public String getTcode() {
		return tcode;
	}
	public void setTcode(String tcode) {
		this.tcode = tcode;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	@Override
	public String toString() {
		return "MonsterDTO [mcode=" + mcode + ", tcode=" + tcode + ", mname=" + mname + ", tname=" + tname + "]";
	}
	
	
	

}
