package org.baseball.kia.eunji.entity;

public class TicketVo {
	
	private String gameDate;
	private String gameTime;
	private String rival;
	private String teamName;
	private String teamImg;
	private String field;
	private String sponsor;
	private int scheduleNo;
	
	public int getScheduleNo() {
		return scheduleNo;
	}
	public void setScheduleNo(int scheduleNo) {
		this.scheduleNo = scheduleNo;
	}
	public String getGameDate() {
		return gameDate;
	}
	public void setGameDate(String gameDate) {
		this.gameDate = gameDate;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getTeamImg() {
		return teamImg;
	}
	public void setTeamImg(String teamImg) {
		this.teamImg = teamImg;
	}
	public String getField() {
		return field;
	}
	public String getSponsor() {
		return sponsor;
	}
	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getGameTime() {
		return gameTime;
	}
	public void setGameTime(String gameTime) {
		this.gameTime = gameTime;
	}
	public String getRival() {
		return rival;
	}
	public void setRival(String rival) {
		this.rival = rival;
	}
	@Override
	public String toString() {
		return "TicketVo [gameDate=" + gameDate + ", gameTime=" + gameTime + ", rival=" + rival + ", teamName="
				+ teamName + ", teamImg=" + teamImg + ", field=" + field + ", sponsor=" + sponsor + ", scheduleNo="
				+ scheduleNo + "]";
	}

	
}
