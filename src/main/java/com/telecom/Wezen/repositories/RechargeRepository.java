package com.telecom.Wezen.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telecom.Wezen.entity.Recharge;
import com.telecom.Wezen.entity.Users;

public interface RechargeRepository extends JpaRepository<Recharge, Long> {

    // Find all recharges by a specific user
    List<Recharge> findByUser(Users user);

    // Optional: Find all recharges by payment status
    List<Recharge> findByPaymentStatus(String paymentStatus);

    
}
