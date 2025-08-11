package com.telecom.Wezen.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // Auto-generates getters, setters, toString, equals, hashCode
@NoArgsConstructor
@Builder
public class User {
	@Id
	private Long id;
	private String name;
	private String mail;
	private String password;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id")
    private Plan plan;
	private String phoneNo;
	private String role;
	
	

}
