package com.telecom.Wezen.controller;

import java.util.List;
import java.util.UUID;

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

import com.telecom.Wezen.dto.TicketCreateRequest;
import com.telecom.Wezen.dto.TicketRespone;
import com.telecom.Wezen.service.ComplaintTicketService;

@RestController
@RequestMapping("/api/complaints")
public class ComplaintTicketController {

    @Autowired
    private ComplaintTicketService complaintTicketService;

    // ✅ Create a new complaint (using DTO)
    @PostMapping("/addComplaint")
    public ResponseEntity<TicketRespone> createComplaint(@RequestBody TicketCreateRequest request) {
        TicketRespone response = complaintTicketService.createComplaint(request);
        return ResponseEntity.ok(response);
    }

    // ✅ Get all complaints (returning DTO responses is cleaner)
    @GetMapping("/getComplaints")
    public ResponseEntity<List<TicketRespone>> getAllComplaints() {
        return ResponseEntity.ok(complaintTicketService.getAllComplaints());
    }

    // ✅ Get complaint by ID
    @GetMapping("/getComplaint/{id}")
    public ResponseEntity<TicketRespone> getComplaintById(@PathVariable UUID id) {
        return ResponseEntity.ok(complaintTicketService.getComplaintById(id));
    }

    // ✅ Update complaint
    @PutMapping("/updateComplaint/{id}")
    public ResponseEntity<TicketRespone> updateComplaint(
            @PathVariable UUID id,
            @RequestBody TicketCreateRequest request
    ) {
        return ResponseEntity.ok(complaintTicketService.updateComplaint(id, request));
    }

    // ✅ Delete complaint
    @DeleteMapping("/deleteComplaint/{id}")
    public ResponseEntity<Void> deleteComplaint(@PathVariable UUID id) {
        complaintTicketService.deleteComplaint(id);
        return ResponseEntity.noContent().build();
    }
}
