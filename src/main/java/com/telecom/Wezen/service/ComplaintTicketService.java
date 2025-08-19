package com.telecom.Wezen.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.telecom.Wezen.entity.ComplaintTicket;
import com.telecom.Wezen.repositories.ComplaintTicketRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ComplaintTicketService {

    private final ComplaintTicketRepository complaintTicketRepository;

    public ComplaintTicket createComplaint(ComplaintTicket complaint) {
        return complaintTicketRepository.save(complaint);
    }

    public List<ComplaintTicket> getAllComplaints() {
        return complaintTicketRepository.findAll();
    }

    public ComplaintTicket getComplaintById(UUID id) {
        return complaintTicketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Complaint not found with id " + id));
    }

    public ComplaintTicket updateComplaint(UUID id, ComplaintTicket updatedComplaint) {
        ComplaintTicket existing = getComplaintById(id);

        existing.setCategory(updatedComplaint.getCategory());
        existing.setSubject(updatedComplaint.getSubject());
        existing.setDescription(updatedComplaint.getDescription());
        existing.setStatus(updatedComplaint.getStatus());
        existing.setPriority(updatedComplaint.getPriority());
        existing.setSlaMinutes(updatedComplaint.getSlaMinutes());
        existing.setDueAt(updatedComplaint.getDueAt());
        existing.setEscalated(updatedComplaint.isEscalated());
        existing.setAssignee(updatedComplaint.getAssignee());

        return complaintTicketRepository.save(existing);
    }

    public void deleteComplaint(UUID id) {
        complaintTicketRepository.deleteById(id);
    }
}
