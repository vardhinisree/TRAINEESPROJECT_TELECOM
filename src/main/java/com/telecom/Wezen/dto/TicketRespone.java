package com.telecom.Wezen.dto;

import java.time.Instant;
import java.util.UUID;

import com.telecom.Wezen.enums.Priority;
import com.telecom.Wezen.enums.TicketStatus;

import lombok.Builder;
import lombok.Data;

@Data 
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
	  
	  public UUID getId() {
		  return id;
	  }
	  public void setId(UUID id) {
		  this.id = id;
	  }
	  public Long getUserId() {
		  return userId;
	  }
	  public void setUserId(Long userId) {
		  this.userId = userId;
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
		return "TicketRespone [id=" + id + ", userId=" + userId + ", category=" + category + ", subject=" + subject
				+ ", description=" + description + ", status=" + status + ", priority=" + priority + ", slaMinutes="
				+ slaMinutes + ", dueAt=" + dueAt + ", escalated=" + escalated + ", assignee=" + assignee
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	  }
	  public TicketRespone() {
		
	  }
	  public void setId(Long long1) {
		// TODO Auto-generated method stub
		
	  }

}
