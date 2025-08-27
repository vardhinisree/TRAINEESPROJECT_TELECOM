package com.telecom.Wezen.controller;

import com.telecom.Wezen.dto.UsageCreateRequest;
import com.telecom.Wezen.entity.Usage_Details;
import com.telecom.Wezen.service.UsageDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usage")
public class UsageDetailsController {

    @Autowired
    private UsageDetailsService usageDetailsService;

    // ✅ Create usage (use @RequestBody for JSONinstead of @RequestParam)
    @PostMapping("/create")
    public Usage_Details createUsage(@RequestBody UsageCreateRequest request) {
        return usageDetailsService.createUsage(
                request.getUserId(),
                request.getRechargeId(),
                request.getCallsUsed(),
                request.getSmsUsed(),
                request.getDataUsed()
        );
    }

    // ✅ Get all usage records
    @GetMapping("/all")
    public List<Usage_Details> getAllUsage() {
        return usageDetailsService.getAllUsageDetails();
    }

    // ✅ Get usage by ID
    @GetMapping("/{id}")
    public Usage_Details getUsageById(@PathVariable Long id) {
        return usageDetailsService.getUsageDetailsById(id);
    }

    // ✅ Update usage
    @PutMapping("/update/{id}")
    public Usage_Details updateUsage(
            @PathVariable Long id,
            @RequestBody Usage_Details usageDetails
    ) {
        return usageDetailsService.updateUsage(
                id,
                usageDetails.getCallsUsed(),
                usageDetails.getSmsUsed(),
                usageDetails.getDataUsed()
        );
    }

    // ✅ Delete usage
    @DeleteMapping("/delete/{id}")
    public boolean deleteUsage(@PathVariable Long id) {
        return usageDetailsService.deleteUsage(id);
    }
}
