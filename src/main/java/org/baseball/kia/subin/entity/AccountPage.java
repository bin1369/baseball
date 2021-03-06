package org.baseball.kia.subin.entity;

import java.util.List;

public class AccountPage extends PageVo {
	private String type;
	private List<AccountVo> accountList;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<AccountVo> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<AccountVo> accountList) {
		this.accountList = accountList;
	}

	@Override
	public String toString() {
		String str = super.toString();
		return str + "\n AccountPage [type=" + type + ", accountList=" + accountList + "]";
	}

}
