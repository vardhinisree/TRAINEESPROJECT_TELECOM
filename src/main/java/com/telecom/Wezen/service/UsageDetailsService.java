package com.telecom.Wezen.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telecom.Wezen.entity.Recharge;
import com.telecom.Wezen.entity.Usage_Details;
import com.telecom.Wezen.entity.Users;
import com.telecom.Wezen.repositories.RechargeRepository;
import com.telecom.Wezen.repositories.UsageRepository;
import com.telecom.Wezen.repositories.UserRepository;

@Service
public class UsageDetailsService {

    @Autowired
    private UsageRepository usageRepository;  // ✅ changed name for consistency

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RechargeRepository rechargeRepository;

    // ✅ Create usage
    public Usage_Details createUsage(Long uuid, Long rechargeId, Integer callsUsed, Integer smsUsed, Double dataUsed) {
        Users user = userRepository.findById(uuid).orElse(null);
        Recharge recharge = rechargeRepository.findById(rechargeId).orElse(null);

        if (user == null || recharge == null) {
            return null; // No exception, return null if not found
        }

        Usage_Details usage = new Usage_Details();
        usage.setUser(user);
        usage.setRecharge(recharge);
        usage.setCallsUsed(callsUsed != null ? callsUsed : 0);
        usage.setSmsUsed(smsUsed != null ? smsUsed : 0);
        usage.setDataUsed(dataUsed != null ? dataUsed : 0.0);
        usage.setUsageDate(LocalDateTime.now());

        return usageRepository.save(usage);  // ✅ fixed
    }

    // ✅ Read all
    public List<Usage_Details> getAllUsageDetails() {
        return usageRepository.findAll();  // ✅ fixed
    }

    // ✅ Read by ID
    public Usage_Details getUsageDetailsById(Long id) {
        return usageRepository.findById(id).orElse(null);  // ✅ fixed
    }

    // ✅ Update usage
    public Usage_Details updateUsage(Long id, Integer callsUsed, Integer smsUsed, Double dataUsed) {
        Usage_Details existing = usageRepository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }

        if (callsUsed != null) existing.setCallsUsed(callsUsed);
        if (smsUsed != null) existing.setSmsUsed(smsUsed);
        if (dataUsed != null) existing.setDataUsed(dataUsed);

        existing.setUsageDate(LocalDateTime.now());

        return usageRepository.save(existing);  // ✅ fixed
    }

    // ✅ Delete usage
    public boolean deleteUsage(Long id) {
        if (usageRepository.existsById(id)) {
            usageRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
