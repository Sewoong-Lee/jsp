package model;

public class SalesDTO {
	private int seq;
	private String saledate;
	private String subcode;
	private String userid;
	private int cnt;
	private int amount;
	
	public SalesDTO() {
		super();
	}

	
	public SalesDTO(String saledate, String subcode, String userid, int cnt, int amount) {
		super();
		this.saledate = saledate;
		this.subcode = subcode;
		this.userid = userid;
		this.cnt = cnt;
		this.amount = amount;
	}


	public SalesDTO(int seq, String saledate, String subcode, String userid, int cnt, int amount) {
		super();
		this.seq = seq;
		this.saledate = saledate;
		this.subcode = subcode;
		this.userid = userid;
		this.cnt = cnt;
		this.amount = amount;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getSaledate() {
		return saledate;
	}

	public void setSaledate(String saledate) {
		this.saledate = saledate;
	}

	public String getSubcode() {
		return subcode;
	}

	public void setSubcode(String subcode) {
		this.subcode = subcode;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "SalesDTO [seq=" + seq + ", saledate=" + saledate + ", subcode=" + subcode + ", userid=" + userid
				+ ", cnt=" + cnt + ", amount=" + amount + "]";
	}
	
	
	
	
}
