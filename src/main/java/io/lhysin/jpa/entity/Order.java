package io.lhysin.jpa.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import io.lhysin.jpa.enums.OrderState;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ORDERS")
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "seq")
    private Long seq;

    // @Column(nullable = false, name = "user_seq")
    // private Long userSeq;

    @Column(nullable = false, name = "product_seq")
    private Long productSeq;

    @Column(nullable = true)
    private Long reviewSeq;

    @Column(columnDefinition = "enum('REQUESTED','ACCEPTED','SHIPPING','COMPLETED','REJECTED') DEFAULT 'REQUESTED' NOT NULL")
    @Enumerated(EnumType.STRING)
    private OrderState state;

    @Column(length = 1000, nullable = true)
    private String requestMsg;

    @Column(length = 1000, nullable = true)
    private String rejectMsg;

    @Column(nullable = true)
    @UpdateTimestamp
    private LocalDateTime completedAt;

    @Column(nullable = true)
    @UpdateTimestamp
    private LocalDateTime rejectedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_seq", insertable = false, updatable = false, referencedColumnName = "seq")
    private User user;
}
