package com.telecom.Wezen.entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "usage_details")   // 👈 avoid reserved keyword "usage"
public class Usage_Details {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Link to User
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    // Link to Recharge
    @ManyToOne
    @JoinColumn(name = "recharge_id", nullable = false)
    private Recharge recharge;

    // Track usage
    private Integer callsUsed;   // in minutes
    private Integer smsUsed;     // number of SMS
    private Double dataUsed;     // in MB/GB

    // Date of usage
    private LocalDateTime usageDate;



    // ----- Getters & Setters -----
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Recharge getRecharge() {
        return recharge;
    }

    public void setRecharge(Recharge recharge) {
        this.recharge = recharge;
    }

    public Integer getCallsUsed() {
        return callsUsed;
    }

    public void setCallsUsed(Integer callsUsed) {
        this.callsUsed = callsUsed;
    }

    public Integer getSmsUsed() {
        return smsUsed;
    }

    public void setSmsUsed(Integer smsUsed) {
        this.smsUsed = smsUsed;
    }

    public Double getDataUsed() {
        return dataUsed;
    }

    public void setDataUsed(Double dataUsed) {
        this.dataUsed = dataUsed;
    }

    public LocalDateTime getUsageDate() {
        return usageDate;
    }

    public void setUsageDate(LocalDateTime usageDate) {
        this.usageDate = usageDate;
    }
}

