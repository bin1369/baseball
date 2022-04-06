package org.baseball.kia.entity;

import java.util.Date;

public class UniformVo {

	int uniformNo, uniInfoNo, uniCnt, total;
	String buyer, refund, state;
	Date buyDate;

	public int getUniformNo() {
		return uniformNo;
	}

	public void setUniformNo(int uniformNo) {
		this.uniformNo = uniformNo;
	}

	public int getUniInfoNo() {
		return uniInfoNo;
	}

	public void setUniInfoNo(int uniInfoNo) {
		this.uniInfoNo = uniInfoNo;
	}

	public int getUniCnt() {
		return uniCnt;
	}

	public void setUniCnt(int uniCnt) {
		this.uniCnt = uniCnt;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public String getRefund() {
		return refund;
	}

	public void setRefund(String refund) {
		this.refund = refund;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	@Override
	public String toString() {
		return "UniformVo [uniformNo=" + uniformNo + ", uniInfoNo=" + uniInfoNo + ", uniCnt=" + uniCnt + ", total="
				+ total + ", buyer=" + buyer + ", refund=" + refund + ", state=" + state + ", buyDate=" + buyDate + "]";
	}

}
