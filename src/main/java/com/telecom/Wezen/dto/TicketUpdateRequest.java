package com.telecom.Wezen.dto;

import com.telecom.Wezen.enums.AuthorType;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TicketUpdateRequest {
	
	@NotNull private AuthorType authorType;
	  @NotNull private String message;

}
