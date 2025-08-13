package com.telecom.Wezen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.telecom.Wezen.entity.Plan;
import com.telecom.Wezen.entity.Users;

public interface PlanRepository extends JpaRepository<Plan, Long> {

}
