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

	  public UUID getId() {
		  return id;
	  }

	  public void setId(UUID id) {
		  this.id = id;
	  }

	  public Users getUser() {
		  return user;
	  }

	  public void setUser(Users user) {
		  this.user = user;
	  }

	  public String getCategory() {
		  return category;
	  }

	  public void setCategory(String category) {
		  this.category = category;
	  }

	  public String getSubject() {
		  return subject;
	  }

	  public void setSubject(String subject) {
		  this.subject = subject;
	  }

	  public String getDescription() {
		  return description;
	  }

	  public void setDescription(String description) {
		  this.description = description;
	  }

	  public TicketStatus getStatus() {
		  return status;
	  }

	  public void setStatus(TicketStatus status) {
		  this.status = status;
	  }

	  public Priority getPriority() {
		  return priority;
	  }

	  public void setPriority(Priority priority) {
		  this.priority = priority;
	  }

	  public Integer getSlaMinutes() {
		  return slaMinutes;
	  }

	  public void setSlaMinutes(Integer slaMinutes) {
		  this.slaMinutes = slaMinutes;
	  }

	  public Instant getDueAt() {
		  return dueAt;
	  }

	  public void setDueAt(Instant dueAt) {
		  this.dueAt = dueAt;
	  }

	  public boolean isEscalated() {
		  return escalated;
	  }

	  public void setEscalated(boolean escalated) {
		  this.escalated = escalated;
	  }

	  public String getAssignee() {
		  return assignee;
	  }

	  public void setAssignee(String assignee) {
		  this.assignee = assignee;
	  }

	  public Instant getCreatedAt() {
		  return createdAt;
	  }

	  public void setCreatedAt(Instant createdAt) {
		  this.createdAt = createdAt;
	  }

	  public Instant getUpdatedAt() {
		  return updatedAt;
	  }

	  public void setUpdatedAt(Instant updatedAt) {
		  this.updatedAt = updatedAt;
	  }

	  @Override
	  public String toString() {
		return "ComplaintTicket [id=" + id + ", user=" + user + ", category=" + category + ", subject=" + subject
				+ ", description=" + description + ", status=" + status + ", priority=" + priority + ", slaMinutes="
				+ slaMinutes + ", dueAt=" + dueAt + ", escalated=" + escalated + ", assignee=" + assignee
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	  }
	

}
