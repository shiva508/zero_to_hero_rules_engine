package com.pool.modal;

public enum RULESESSIONS {
	DSLNR("dlsnrRuleVerificationSession"), HYD("hydRuleVerificationSession");

	 public String ruleSessionName;

	RULESESSIONS(String ruleSessionName) {
		this.ruleSessionName = ruleSessionName;
	}

	public String getRuleSessionName() {
		return ruleSessionName;
	}

	public void setRuleSessionName(String ruleSessionName) {
		this.ruleSessionName = ruleSessionName;
	}
	
}
