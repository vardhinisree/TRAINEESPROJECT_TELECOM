// com.telecom.Wezen.entity.TicketUpdate
package com.telecom.Wezen.entity;

import com.telecom.Wezen.enums.AuthorType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity @Table(name = "ticket_update")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class TicketUpdate {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ticket_id")
  @com.fasterxml.jackson.annotation.JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
  private ComplaintTicket ticket;

  @Enumerated(EnumType.STRING)
  private AuthorType authorType;

  @Column(length = 4000)
  private String message;

  @CreationTimestamp
  private Instant createdAt;
}
