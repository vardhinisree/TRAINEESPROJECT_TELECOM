package com.telecom.Wezen.dto;

import com.telecom.Wezen.enums.TicketStatus;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StatusChangeRequest {
	 @NotNull private TicketStatus status;

	 public TicketStatus getStatus() {
		 return status;
	 }

	 public void setStatus(TicketStatus status) {
		 this.status = status;
	 }

	 @Override
	 public String toString() {
		return "StatusChangeRequest [status=" + status + "]";
	 }

}
