package com.telecom.Wezen.entity;


import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import com.telecom.Wezen.enums.PaymentMode;
import com.telecom.Wezen.enums.PaymentStatus;
import com.telecom.Wezen.enums.RechargeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recharge {


	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    // The user who performed the recharge
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "user_id", nullable = false)
	    private Users user;

	    // The plan against which recharge was made (optional, if recharge tied to a plan)
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
	private RechargeType rechargeType; // Optional

	public void setId(Long id2) {
		// TODO Auto-generated method stub
		
	}


}

