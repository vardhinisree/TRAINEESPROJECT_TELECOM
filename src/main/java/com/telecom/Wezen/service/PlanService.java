package com.telecom.Wezen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.telecom.Wezen.entity.Plan;
import com.telecom.Wezen.repositories.PlanRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PlanService {

    private final PlanRepository planRepository;

    public PlanService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public List<Plan> getAllPlans() {
        return planRepository.findAll();
    }

    public Optional<Plan> getPlanById(Long id) {
        return planRepository.findById(id);
    }

    public Plan createPlan(Plan plan) {
        return planRepository.save(plan);
    }

    public Optional<Plan> updatePlan(Long id, Plan updatedPlan) {
        if (planRepository.existsById(id)) {
            updatedPlan.setPlan_id(id);
            return Optional.of(planRepository.save(updatedPlan));
        }
        return Optional.empty();
    }

    public void deletePlan(Long id) {
        planRepository.deleteById(id);
    }
}
