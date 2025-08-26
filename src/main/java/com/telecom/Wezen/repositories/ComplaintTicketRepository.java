package com.telecom.Wezen.repositories;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telecom.Wezen.entity.ComplaintTicket;
import com.telecom.Wezen.enums.TicketStatus;

public interface ComplaintTicketRepository  extends JpaRepository<ComplaintTicket,UUID>{
	List<ComplaintTicket> findByStatusAndDueAtBefore(TicketStatus status, Instant now);

}
