package com.telecom.Wezen.service;

import java.util.List;
import java.util.Optional;

import com.telecom.Wezen.entity.Recharge;
import com.telecom.Wezen.entity.Users;
import com.telecom.Wezen.repositories.RechargeRepository;

public class RechargeService {

    private final RechargeRepository rechargeRepository;

    public RechargeService(RechargeRepository rechargeRepository) {
        this.rechargeRepository = rechargeRepository;
    }

    public List<Recharge> getAllRecharges() {
        return rechargeRepository.findAll();
    }

    public Optional<Recharge> getRechargeById(Long id) {
        return rechargeRepository.findById(id);
    }

    public Recharge saveRecharge(Recharge recharge) {
        return rechargeRepository.save(recharge);
    }

    public void deleteRecharge(Long id) {
        rechargeRepository.deleteById(id);
    }

    // Get all recharges by a user
    public List<Recharge> getRechargesByUser(Users user) {
        return rechargeRepository.findByUser(user);
    }


}
