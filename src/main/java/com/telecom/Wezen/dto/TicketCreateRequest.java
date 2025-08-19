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

}
