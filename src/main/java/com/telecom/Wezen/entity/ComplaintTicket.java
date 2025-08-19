package com.telecom.Wezen.entity;

import java.time.Instant;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.telecom.Wezen.enums.Priority;
import com.telecom.Wezen.enums.TicketStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table(name="complaints")
@Getter
@Setter
@NoArgsConstructor
@Builder
public class ComplaintTicket {
	@Id
	@GeneratedValue
	private UUID id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private Users user;
	// complaint details :
	private String category;
	  private String subject;

	  @Column(length = 4000)
	  private String description;

	  @Enumerated(EnumType.STRING)
	  private TicketStatus status;

	  @Enumerated(EnumType.STRING)
	  private Priority priority;

	  // simple SLA handling in minutes
	  private Integer slaMinutes;

	  private Instant dueAt;
	  private boolean escalated;

	  private String assignee; // optional: team/agent name or email

	  @CreationTimestamp
	  private Instant createdAt;

	  @UpdateTimestamp
	  private Instant updatedAt;
	

}
