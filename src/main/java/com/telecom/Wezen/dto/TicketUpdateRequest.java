package com.telecom.Wezen.dto;

import com.telecom.Wezen.enums.AuthorType;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TicketUpdateRequest {
	
	@NotNull private AuthorType authorType;
	  @NotNull private String message;
	  public AuthorType getAuthorType() {
		  return authorType;
	  }
	  public void setAuthorType(AuthorType authorType) {
		  this.authorType = authorType;
	  }
	  public String getMessage() {
		  return message;
	  }
	  public void setMessage(String message) {
		  this.message = message;
	  }
	  @Override
	  public String toString() {
		return "TicketUpdateRequest [authorType=" + authorType + ", message=" + message + "]";
	  }

	  
}
