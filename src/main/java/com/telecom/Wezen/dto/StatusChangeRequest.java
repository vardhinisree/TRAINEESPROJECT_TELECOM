package com.telecom.Wezen.dto;

import com.telecom.Wezen.enums.TicketStatus;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StatusChangeRequest {
	 @NotNull private TicketStatus status;

}
