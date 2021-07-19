package model;

public class SubjectDTO {
	private String subcode;
	private String subname;
	private int price;
	private String filename;
	private String kwcode;
	
	public SubjectDTO() {
		super();
	}
	
	public SubjectDTO(String subcode, String subname, int price, String filename, String kwcode) {
		super();
		this.subcode = subcode;
		this.subname = subname;
		this.price = price;
		this.filename = filename;
		this.kwcode = kwcode;
	}


	public String getSubcode() {
		return subcode;
	}

	public void setSubcode(String subcode) {
		this.subcode = subcode;
	}

	public String getSubname() {
		return subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getKwcode() {
		return kwcode;
	}

	public void setKwcode(String kwcode) {
		this.kwcode = kwcode;
	}

	@Override
	public String toString() {
		return "SubjectDTO [subcode=" + subcode + ", subname=" + subname + ", price=" + price + ", filename=" + filename
				+ ", kwcode=" + kwcode + "]";
	}
	
	
	
	
}
