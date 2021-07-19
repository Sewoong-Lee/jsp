package model;

public class KeywordDTO {
	private String kwcode;
	private String kwname;
	
	public KeywordDTO() {
		super();
	}
	public KeywordDTO(String kwcode, String kwname) {
		super();
		this.kwcode = kwcode;
		this.kwname = kwname;
	}
	public String getKwcode() {
		return kwcode;
	}
	public void setKwcode(String kwcode) {
		this.kwcode = kwcode;
	}
	public String getKwname() {
		return kwname;
	}
	public void setKwname(String kwname) {
		this.kwname = kwname;
	}
	@Override
	public String toString() {
		return "KeywordDTO [kwcode=" + kwcode + ", kwname=" + kwname + "]";
	}
	
	
	
}
