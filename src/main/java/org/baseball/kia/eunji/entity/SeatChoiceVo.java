package org.baseball.kia.eunji.entity;

public class SeatChoiceVo {
	
	//주중주말 요금, 구역, 구역별 제한 
	private int baseInfoNo;
	private int priceWeekday; 
	private int limit;
	private int priceWeekend;
	private String baseballZone;
	
	
	
	public int getBaseInfoNo() {
		return baseInfoNo;
	}
	public void setBaseInfoNo(int baseInfoNo) {
		this.baseInfoNo = baseInfoNo;
	}
	public int getPriceWeekday() {
		return priceWeekday;
	}
	public void setPriceWeekday(int priceWeekday) {
		this.priceWeekday = priceWeekday;
	}
	
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	 
	public int getPriceWeekend() {
		return priceWeekend;
	}
	public void setPriceWeekend(int priceWeekend) {
		this.priceWeekend = priceWeekend;
	}
	public String getBaseballZone() {
		return baseballZone;
	}
	public void setBaseballZone(String baseballZone) {
		this.baseballZone = baseballZone;
	}
	
	

}
