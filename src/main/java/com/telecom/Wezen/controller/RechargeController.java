package com.telecom.Wezen.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.telecom.Wezen.entity.Recharge;
import com.telecom.Wezen.entity.Users;
import com.telecom.Wezen.service.RechargeService;
import com.telecom.Wezen.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

public class RechargeController {
	  private final RechargeService rechargeService;
	    private final UserService userService; // to fetch Users when needed

	    public RechargeController(RechargeService rechargeService, UserService userService) {
	        this.rechargeService = rechargeService;
	        this.userService = userService;
	    }

	    // Get all recharges
	    @GetMapping
	    public List<Recharge> getAllRecharges() {
	        return rechargeService.getAllRecharges();
	    }

	    // Get recharge by ID
	    @GetMapping("/{id}")
	    public ResponseEntity<Recharge> getRechargeById(@PathVariable Long id) {
	        return rechargeService.getRechargeById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	    // Get all recharges by a specific user
	    @GetMapping("/user/{userId}")
	    public ResponseEntity<List<Recharge>> getRechargesByUser(@PathVariable Long userId) {
	        Users user = userService.getUserById(userId);
	        if (user == null) {
	            return ResponseEntity.notFound().build();
	        }
	        List<Recharge> recharges = rechargeService.getRechargesByUser(user);
	        return ResponseEntity.ok(recharges);
	    }

	    // Create new recharge
	    @PostMapping
	    public ResponseEntity<Recharge> createRecharge(@RequestBody Recharge recharge) {
	        Recharge savedRecharge = rechargeService.saveRecharge(recharge);
	        return ResponseEntity.ok(savedRecharge);
	    }

	    // Update existing recharge
	    @PutMapping("/{id}")
	    public ResponseEntity<Recharge> updateRecharge(@PathVariable Long id, @RequestBody Recharge updatedRecharge) {
	        return rechargeService.getRechargeById(id)
	                .map(existingRecharge -> {
	                    updatedRecharge.setId(id);
	                    Recharge saved = rechargeService.saveRecharge(updatedRecharge);
	                    return ResponseEntity.ok(saved);
	                })
	                .orElse(ResponseEntity.notFound().build());
	    }

	    // Delete recharge
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteRecharge(@PathVariable Long id) {
	        rechargeService.deleteRecharge(id);
	        return ResponseEntity.noContent().build();
	    }
	}

