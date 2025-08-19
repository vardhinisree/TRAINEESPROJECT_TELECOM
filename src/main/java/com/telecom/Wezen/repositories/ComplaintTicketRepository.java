package com.telecom.Wezen.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telecom.Wezen.entity.ComplaintTicket;

public interface ComplaintTicketRepository  extends JpaRepository<ComplaintTicket,UUID>{

}
