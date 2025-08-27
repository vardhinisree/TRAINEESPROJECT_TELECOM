package com.telecom.Wezen.service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.telecom.Wezen.dto.TicketCreateRequest;
import com.telecom.Wezen.dto.TicketRespone;
import com.telecom.Wezen.entity.ComplaintTicket;
import com.telecom.Wezen.entity.Users;
import com.telecom.Wezen.enums.TicketStatus;
import com.telecom.Wezen.repositories.ComplaintTicketRepository;
import com.telecom.Wezen.repositories.UserRepository;

@Service
public class ComplaintTicketService {

    @Autowired
    private ComplaintTicketRepository complaintTicketRepository;
    private static final Logger logger = LoggerFactory.getLogger(ComplaintTicketService.class);
    

    @Autowired
    private UserRepository userRepository;

    // ✅ Create complaint
    public TicketRespone createComplaint(TicketCreateRequest request) {
        Users user = userRepository.findById(request.getUserId()).orElse(null);

        ComplaintTicket complaint = new ComplaintTicket();
        complaint.setUser(user);
        complaint.setCategory(request.getCategory());
        complaint.setSubject(request.getSubject());
        complaint.setDescription(request.getDescription());
        complaint.setPriority(request.getPriority());
        complaint.setStatus(TicketStatus.OPEN);
        complaint.setSlaMinutes(1);
        complaint.setDueAt(Instant.now().plusSeconds(1 * 60));
        complaint.setEscalated(false);
        complaint.setAssignee("support-team@telecom.com");
        complaint.setCreatedAt(Instant.now());
        complaint.setUpdatedAt(Instant.now());

        ComplaintTicket saved = complaintTicketRepository.save(complaint);
        return mapToResponse(saved);
    }

    // ✅ Get all complaints
    public List<TicketRespone> getAllComplaints() {
        return complaintTicketRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ✅ Get complaint by ID
    public TicketRespone getComplaintById(UUID id) {
        return complaintTicketRepository.findById(id)
                .map(this::mapToResponse)
                .orElse(null);
    }

    // ✅ Update complaint
    public TicketRespone updateComplaint(UUID id, TicketCreateRequest request) {
        ComplaintTicket existing = complaintTicketRepository.findById(id).orElse(null);
        if (existing == null) return null;

        Users user = userRepository.findById(request.getUserId()).orElse(null);

        existing.setUser(user);
        existing.setCategory(request.getCategory());
        existing.setSubject(request.getSubject());
        existing.setDescription(request.getDescription());
        existing.setPriority(request.getPriority());
        existing.setUpdatedAt(Instant.now());

        ComplaintTicket updated = complaintTicketRepository.save(existing);
        return mapToResponse(updated);
    }

    // ✅ Delete complaint
    public void deleteComplaint(UUID id) {
        complaintTicketRepository.deleteById(id);
    }

    // ✅ Helper mapper
    private TicketRespone mapToResponse(ComplaintTicket ticket) {
        TicketRespone response = new TicketRespone();
        response.setId(ticket.getId());
        response.setId(ticket.getUser() != null ? ticket.getUser().getId() : null);
        response.setCategory(ticket.getCategory());
        response.setSubject(ticket.getSubject());
        response.setDescription(ticket.getDescription());
        response.setPriority(ticket.getPriority());
        response.setStatus(ticket.getStatus());
        response.setSlaMinutes(ticket.getSlaMinutes());
        response.setDueAt(ticket.getDueAt());
        response.setEscalated(ticket.isEscalated());
        response.setAssignee(ticket.getAssignee());
        response.setCreatedAt(ticket.getCreatedAt());
        response.setUpdatedAt(ticket.getUpdatedAt());
        return response;
    }
    @Scheduled(fixedRate = 300000)  // runs every 5 minutes (300,000 ms)
    public void checkSlaBreaches() {
        Instant now = Instant.now();
        
        List<ComplaintTicket> overdueTickets = complaintTicketRepository
       .findByStatusAndDueAtBefore(TicketStatus.OPEN, now);

        for (ComplaintTicket ticket : overdueTickets) {
            if (!ticket.isEscalated()) {
                ticket.setEscalated(true);
                ticket.setAssignee("senior-support@telecom.com"); // example escalation
                complaintTicketRepository.save(ticket);

                logger.info("Escalated ticket ID {} as SLA breached at {}", 
                            ticket.getId(), now);
            }
        }
    }

    
}
