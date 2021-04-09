package io.lhysin.jpa.entity;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USERS")
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
// property = "seq")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long seq;

    @Column(length = 10, nullable = false)
    private String name;

    @Column(length = 20, nullable = false, unique = true)
    private String email;

    @Column(length = 80, nullable = false)
    private String passwd;

    @Column(nullable = false, columnDefinition = "integer default 0")
    private Integer loginCount;

    @Column(nullable = true)
    @UpdateTimestamp
    private LocalDateTime lastLoginAt;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Collection<Order> orders;

    public void changePasswd(String passwd) {
        this.passwd = passwd;
    }

    public void increaseLoginCount() {
        this.loginCount++;
    }

    public void updateLoginAt() {
        this.lastLoginAt = LocalDateTime.now();
    }
}
