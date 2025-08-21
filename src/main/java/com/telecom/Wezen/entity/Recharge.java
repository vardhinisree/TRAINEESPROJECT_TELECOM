package com.telecom.Wezen.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import com.telecom.Wezen.enums.PaymentMode;
import com.telecom.Wezen.enums.PaymentStatus;
import com.telecom.Wezen.enums.RechargeType;

@Entity
public class Recharge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // The user who performed the recharge
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    // The plan against which recharge was made (optional)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id")
    private Plan plan;

    // Recharge amount
    @Column(nullable = false)
    private BigDecimal amount;

    // Date & time of recharge
    @Column(nullable = false)
    private LocalDateTime rechargeDate;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;

    @Enumerated(EnumType.STRING)
    private RechargeType rechargeType;

    // ----------------- Constructors -----------------
    public Recharge() {
    }

    public Recharge(Long id, Users user, Plan plan, BigDecimal amount,
                    LocalDateTime rechargeDate, PaymentStatus paymentStatus,
                    PaymentMode paymentMode, RechargeType rechargeType) {
        this.id = id;
        this.user = user;
        this.plan = plan;
        this.amount = amount;
        this.rechargeDate = rechargeDate;
        this.paymentStatus = paymentStatus;
        this.paymentMode = paymentMode;
        this.rechargeType = rechargeType;
    }

    // ----------------- Getters & Setters -----------------
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getRechargeDate() {
        return rechargeDate;
    }

    public void setRechargeDate(LocalDateTime rechargeDate) {
        this.rechargeDate = rechargeDate;
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
		return "Recharge [id=" + id + ", user=" + user + ", plan=" + plan + ", amount=" + amount + ", rechargeDate="
				+ rechargeDate + ", paymentStatus=" + paymentStatus + ", paymentMode=" + paymentMode + ", rechargeType="
				+ rechargeType + "]";
	}

    // ----------------- toString -----------------

    }



