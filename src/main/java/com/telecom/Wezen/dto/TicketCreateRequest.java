package com.telecom.Wezen.dto;

import com.telecom.Wezen.enums.Priority;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TicketCreateRequest {
	@NotNull private Long userId;
	  @NotNull private String category;
	  @NotNull private String subject;
	  @NotNull private String description;
	  @NotNull private Priority priority;
	  
	  public TicketCreateRequest() { }

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

	  public Priority getPriority() {
		  return priority;
	  }

	  public void setPriority(Priority priority) {
		  this.priority = priority;
	  }

	  @Override
	  public String toString() {
		return "TicketCreateRequest [userId=" + userId + ", category=" + category + ", subject=" + subject
				+ ", description=" + description + ", priority=" + priority + "]";
	  }
	  
	  

}
