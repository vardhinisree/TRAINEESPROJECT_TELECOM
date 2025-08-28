package com.telecom.Wezen.dto;

import java.math.BigDecimal;

public class PlanDTO {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private int validityDays;

    public PlanDTO() {}

    public PlanDTO(Long id, String name, String description, BigDecimal price, int validityDays) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.validityDays = validityDays;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getValidityDays() {
        return validityDays;
    }

    public void setValidityDays(int validityDays) {
        this.validityDays = validityDays;
    }
}
