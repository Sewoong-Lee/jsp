package dto;

//페이지 처리 위한 dto
public class PageDTO {
	private int curpage; //현재 페이지
	private int totpage; //전체 페이지
	private int perpage=10; //한페이지당 게시물수
	private int startno; //시작번호
	private int endno; //끝번호
	
	private int perblock=7; //페이지 블럭의 수
	private int startpage; //블럭의 시작 페이지 
	private int endpage; // 블럭의 끝 페이지
	
	private String findkey; //검색키
	private String findvalue; //검색값
	public int getCurpage() {
		return curpage;
	}
	public void setCurpage(int curpage) {
		this.curpage = curpage;
	}
	public int getTotpage() {
		return totpage;
	}
	public void setTotpage(int totpage) {
		this.totpage = totpage;
	}
	public int getPerpage() {
		return perpage;
	}
	public void setPerpage(int perpage) {
		this.perpage = perpage;
	}
	public int getStartno() {
		return startno;
	}
	public void setStartno(int startno) {
		this.startno = startno;
	}
	public int getEndno() {
		return endno;
	}
	public void setEndno(int endno) {
		this.endno = endno;
	}
	public int getPerblock() {
		return perblock;
	}
	public void setPerblock(int perblock) {
		this.perblock = perblock;
	}
	public int getStartpage() {
		return startpage;
	}
	public void setStartpage(int startpage) {
		this.startpage = startpage;
	}
	public int getEndpage() {
		return endpage;
	}
	public void setEndpage(int endpage) {
		this.endpage = endpage;
	}
	public String getFindkey() {
		return findkey;
	}
	public void setFindkey(String findkey) {
		this.findkey = findkey;
	}
	public String getFindvalue() {
		return findvalue;
	}
	public void setFindvalue(String findvalue) {
		this.findvalue = findvalue;
	}
	@Override
	public String toString() {
		return "PageDTO [curpage=" + curpage + ", totpage=" + totpage + ", perpage=" + perpage + ", startno=" + startno
				+ ", endno=" + endno + ", perblock=" + perblock + ", startpage=" + startpage + ", endpage=" + endpage
				+ ", findkey=" + findkey + ", findvalue=" + findvalue + "]";
	}
	
	
}
