package com.telecom.Wezen.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import com.telecom.Wezen.enums.PaymentMode;
import com.telecom.Wezen.enums.PaymentStatus;
import com.telecom.Wezen.enums.RechargeType;

public class RechargeRequest {
    
    @NotNull(message = "User ID is required")
    private Long userId;
    
    private Long planId;
    
    @NotNull(message = "Amount is required")
    private BigDecimal amount;
    
    private PaymentStatus paymentStatus;
    private PaymentMode paymentMode;
    private RechargeType rechargeType;

    // Getters and Setters
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getPlanId() {
        return planId;
    }
    public void setPlanId(Long planId) {
        this.planId = planId;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }
    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    public PaymentMode getPaymentMode() {
        return paymentMode;
    }
    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }
    public RechargeType getRechargeType() {
        return rechargeType;
    }
    public void setRechargeType(RechargeType rechargeType) {
        this.rechargeType = rechargeType;
    }
    
    @Override
    public String toString() {
        return "RechargeRequest [userId=" + userId + ", planId=" + planId + ", amount=" + amount + ", paymentStatus="
                + paymentStatus + ", paymentMode=" + paymentMode + ", rechargeType=" + rechargeType + "]";
    }
}


