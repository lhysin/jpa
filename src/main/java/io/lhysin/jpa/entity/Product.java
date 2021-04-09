package io.lhysin.jpa.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PRODUCTS")
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long seq;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 1000, nullable = true)
    private String details;

    @Column(nullable = false)
    private Integer reviewCount;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_seq", insertable = false, updatable = false, referencedColumnName = "seq")
    private List<Review> reviews;
}
