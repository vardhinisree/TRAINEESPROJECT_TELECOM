package com.telecom.Wezen.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telecom.Wezen.dto.RechargeRequest;
import com.telecom.Wezen.entity.Plan;
import com.telecom.Wezen.entity.Recharge;
import com.telecom.Wezen.entity.Users;
import com.telecom.Wezen.repositories.PlanRepository;
import com.telecom.Wezen.repositories.RechargeRepository;
import com.telecom.Wezen.repositories.UserRepository;

@Service
public class RechargeService {

    @Autowired
    private RechargeRepository rechargeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlanRepository planRepository;

    // ✅ Create Recharge with proper validation
    public Recharge createRecharge(RechargeRequest dto) {
        // Validate required fields
        if (dto.getUserId() == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }
        
        if (dto.getAmount() == null) {
            throw new IllegalArgumentException("Amount cannot be null");
        }

        // Find user with proper error handling
        Users user = userRepository.findById(dto.getUserId())
            .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + dto.getUserId()));

        // Find plan if provided
        Plan plan = null;
        if (dto.getPlanId() != null) {
            plan = planRepository.findById(dto.getPlanId())
                .orElseThrow(() -> new IllegalArgumentException("Plan not found with ID: " + dto.getPlanId()));
        }

        // Create and save recharge
        Recharge recharge = new Recharge();
        recharge.setUser(user);
        recharge.setPlan(plan);
        recharge.setAmount(dto.getAmount());
        recharge.setRechargeDate(LocalDateTime.now());
        recharge.setPaymentStatus(dto.getPaymentStatus());
        recharge.setPaymentMode(dto.getPaymentMode());
        recharge.setRechargeType(dto.getRechargeType());

        return rechargeRepository.save(recharge);
    }

    // ✅ Read all
    public List<Recharge> getAllRecharges() {
        return rechargeRepository.findAll();
    }

    // ✅ Read by id
    public Optional<Recharge> getRechargeById(Long id) {
        return rechargeRepository.findById(id);
    }

    // ✅ Update Recharge with validation
    public Recharge updateRecharge(Long id, RechargeRequest dto) {
        // Validate required fields
        if (dto.getUserId() == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }
        
        if (dto.getAmount() == null) {
            throw new IllegalArgumentException("Amount cannot be null");
        }

        // Find existing recharge
        Recharge existing = rechargeRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Recharge not found with ID: " + id));

        // Find user
        Users user = userRepository.findById(dto.getUserId())
            .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + dto.getUserId()));

        // Find plan if provided
        Plan plan = null;
        if (dto.getPlanId() != null) {
            plan = planRepository.findById(dto.getPlanId())
                .orElseThrow(() -> new IllegalArgumentException("Plan not found with ID: " + dto.getPlanId()));
        }

        // Update fields
        existing.setUser(user);
        existing.setPlan(plan);
        existing.setAmount(dto.getAmount());
        existing.setPaymentStatus(dto.getPaymentStatus());
        existing.setPaymentMode(dto.getPaymentMode());
        existing.setRechargeType(dto.getRechargeType());
        existing.setRechargeDate(LocalDateTime.now());

        return rechargeRepository.save(existing);
    }

    // ✅ Delete
    public void deleteRecharge(Long id) {
        if (!rechargeRepository.existsById(id)) {
            throw new IllegalArgumentException("Recharge not found with ID: " + id);
        }
        rechargeRepository.deleteById(id);
    }
}