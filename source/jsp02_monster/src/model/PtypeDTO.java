package model;

public class PtypeDTO {
	private String tcode;
	private String tname;
	
	public PtypeDTO() {
		super();
	}

	public PtypeDTO(String tcode, String tname) {
		super();
		this.tcode = tcode;
		this.tname = tname;
	}

	public String getTcode() {
		return tcode;
	}

	public void setTcode(String tcode) {
		this.tcode = tcode;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	@Override
	public String toString() {
		return "PtypeDTO [tcode=" + tcode + ", tname=" + tname + "]";
	}
	
	
}
