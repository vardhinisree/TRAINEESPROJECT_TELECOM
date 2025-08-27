package com.telecom.Wezen.dto;

import java.util.UUID;

public class UsageCreateRequest {
    private Long userId;
    private Long rechargeId;
    private Integer callsUsed;
    private Integer smsUsed;
    private Double dataUsed;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getRechargeId() {
		return rechargeId;
	}
	public void setRechargeId(Long rechargeId) {
		this.rechargeId = rechargeId;
	}
	public Integer getCallsUsed() {
		return callsUsed;
	}
	public void setCallsUsed(Integer callsUsed) {
		this.callsUsed = callsUsed;
	}
	public Integer getSmsUsed() {
		return smsUsed;
	}
	public void setSmsUsed(Integer smsUsed) {
		this.smsUsed = smsUsed;
	}
	public Double getDataUsed() {
		return dataUsed;
	}
	public void setDataUsed(Double dataUsed) {
		this.dataUsed = dataUsed;
	}

    // getters & setters
    
}