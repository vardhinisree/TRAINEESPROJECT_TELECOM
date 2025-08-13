package com.telecom.Wezen.entity;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Map;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // Auto-generates getters, setters, toString, equals, hashCode
@NoArgsConstructor
@Builder
public class Plan {
	@Id
	private Long plan_id;
	private String plan_type;
	private Integer validityDays;
	private String password;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "plan_data_packs", joinColumns = @JoinColumn(name = "plan_id"))
    @MapKeyColumn(name = "price")
    @Column(name = "mb")
    private Map<BigDecimal, Long> dataPacks;
    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updatedAt;
    
    public Plan() {}

	public Long getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(Long plan_id) {
		this.plan_id = plan_id;
	}

	public String getPlan_type() {
		return plan_type;
	}

	public void setPlan_type(String plan_type) {
		this.plan_type = plan_type;
	}

	public Integer getValidityDays() {
		return validityDays;
	}

	public void setValidityDays(Integer validityDays) {
		this.validityDays = validityDays;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map<BigDecimal, Long> getDataPacks() {
		return dataPacks;
	}

	public void setDataPacks(Map<BigDecimal, Long> dataPacks) {
		this.dataPacks = dataPacks;
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
		return "Plan [plan_id=" + plan_id + ", plan_type=" + plan_type + ", validityDays=" + validityDays
				+ ", password=" + password + ", dataPacks=" + dataPacks + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + "]";
	}
    
    
}
