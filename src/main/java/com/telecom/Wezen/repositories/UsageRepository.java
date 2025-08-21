package com.telecom.Wezen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telecom.Wezen.entity.Plan;

public interface UsageRepository extends JpaRepository<Plan, Long> {

}
