package dto;

public class FileDTO {
	private int fnum;
	private int bnum;
	private String filename;
	
	public FileDTO() {
		super();
	}

	public FileDTO(int fnum, int bnum, String filename) {
		super();
		this.fnum = fnum;
		this.bnum = bnum;
		this.filename = filename;
	}

	public int getFnum() {
		return fnum;
	}

	public void setFnum(int fnum) {
		this.fnum = fnum;
	}

	public int getBnum() {
		return bnum;
	}

	public void setBnum(int bnum) {
		this.bnum = bnum;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Override
	public String toString() {
		return "FileDTO [fnum=" + fnum + ", bnum=" + bnum + ", filename=" + filename + "]";
	}
	
	
	
}
