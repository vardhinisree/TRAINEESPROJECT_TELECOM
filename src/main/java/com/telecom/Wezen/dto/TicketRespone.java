package com.telecom.Wezen.dto;

import java.time.Instant;
import java.util.UUID;

import com.telecom.Wezen.enums.Priority;
import com.telecom.Wezen.enums.TicketStatus;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class TicketRespone {
	private UUID id;
	  private Long userId;
	  private String category;
	  private String subject;
	  private String description;
	  private TicketStatus status;
	  private Priority priority;
	  private Integer slaMinutes;
	  private Instant dueAt;
	  private boolean escalated;
	  private String assignee;
	  private Instant createdAt;
	  private Instant updatedAt;

}
