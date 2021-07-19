package dto;

public class CovidDTO {
	private String stateDt;
	private String stateTime;
	private int decideCnt;  //확진자수
	private String accDefRate; 
	private String clearCnt;
	private String examCnt;
	private String accExamCnt;
	private String deathCnt;
	private String resutlNegCnt;
	private String accExamCompCnt;
	private String careCnt;
	private String createDt;
	private String updateDt;
	private String diffcnt;
	
	public String getDiffcnt() {
		return diffcnt;
	}
	public void setDiffcnt(String diffcnt) {
		this.diffcnt = diffcnt;
	}
	public String getStateDt() {
		return stateDt;
	}
	public void setStateDt(String stateDt) {
		this.stateDt = stateDt;
	}
	public String getStateTime() {
		return stateTime;
	}
	public void setStateTime(String stateTime) {
		this.stateTime = stateTime;
	}
	public int getDecideCnt() {
		return decideCnt;
	}
	public void setDecideCnt(int decideCnt) {
		this.decideCnt = decideCnt;
	}
	public String getAccDefRate() {
		return accDefRate;
	}
	public void setAccDefRate(String accDefRate) {
		this.accDefRate = accDefRate;
	}
	public String getClearCnt() {
		return clearCnt;
	}
	public void setClearCnt(String clearCnt) {
		this.clearCnt = clearCnt;
	}
	public String getExamCnt() {
		return examCnt;
	}
	public void setExamCnt(String examCnt) {
		this.examCnt = examCnt;
	}
	public String getAccExamCnt() {
		return accExamCnt;
	}
	public void setAccExamCnt(String accExamCnt) {
		this.accExamCnt = accExamCnt;
	}
	public String getDeathCnt() {
		return deathCnt;
	}
	public void setDeathCnt(String deathCnt) {
		this.deathCnt = deathCnt;
	}
	public String getResutlNegCnt() {
		return resutlNegCnt;
	}
	public void setResutlNegCnt(String resutlNegCnt) {
		this.resutlNegCnt = resutlNegCnt;
	}
	public String getAccExamCompCnt() {
		return accExamCompCnt;
	}
	public void setAccExamCompCnt(String accExamCompCnt) {
		this.accExamCompCnt = accExamCompCnt;
	}
	public String getCareCnt() {
		return careCnt;
	}
	public void setCareCnt(String careCnt) {
		this.careCnt = careCnt;
	}
	public String getCreateDt() {
		return createDt;
	}
	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}
	public String getUpdateDt() {
		return updateDt;
	}
	public void setUpdateDt(String updateDt) {
		this.updateDt = updateDt;
	}
	@Override
	public String toString() {
		return "CovidDTO [stateDt=" + stateDt + ", stateTime=" + stateTime + ", decideCnt=" + decideCnt
				+ ", accDefRate=" + accDefRate + ", clearCnt=" + clearCnt + ", examCnt=" + examCnt + ", accExamCnt="
				+ accExamCnt + ", deathCnt=" + deathCnt + ", resutlNegCnt=" + resutlNegCnt + ", accExamCompCnt="
				+ accExamCompCnt + ", careCnt=" + careCnt + ", createDt=" + createDt + ", updateDt=" + updateDt
				+ ", diffcnt=" + diffcnt + "]";
	}
	
	
	
	
	
	
	
	
	
}
