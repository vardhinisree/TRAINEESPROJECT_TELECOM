package com.telecom.Wezen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.Wezen.dto.RechargeRequest;
import com.telecom.Wezen.entity.Recharge;
import com.telecom.Wezen.service.RechargeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/recharges")
public class RechargeController {

    @Autowired
    private RechargeService rechargeService;

    // ✅ Create Recharge (POST)
    @PostMapping
    public ResponseEntity<?> createRecharge(@Valid @RequestBody RechargeRequest rechargeDTO) {
        try {
            Recharge recharge = rechargeService.createRecharge(rechargeDTO);
            return ResponseEntity.ok(recharge);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error creating recharge: " + e.getMessage());
        }
    }

    // ✅ Get All Recharges (GET)
    @GetMapping
    public ResponseEntity<List<Recharge>> getAllRecharges() {
        return ResponseEntity.ok(rechargeService.getAllRecharges());
    }

    // ✅ Get Recharge By Id (GET)
    @GetMapping("/{id}")
    public ResponseEntity<?> getRechargeById(@PathVariable Long id) {
        try {
            return rechargeService.getRechargeById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error fetching recharge: " + e.getMessage());
        }
    }

    // ✅ Update Recharge (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<?> updateRecharge(
            @PathVariable Long id,
            @Valid @RequestBody RechargeRequest rechargeDTO) {
        try {
            Recharge updatedRecharge = rechargeService.updateRecharge(id, rechargeDTO);
            return ResponseEntity.ok(updatedRecharge);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error updating recharge: " + e.getMessage());
        }
    }

    // ✅ Delete Recharge (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRecharge(@PathVariable Long id) {
        try {
            rechargeService.deleteRecharge(id);
            return ResponseEntity.ok("Recharge deleted successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error deleting recharge: " + e.getMessage());
        }
    }
}