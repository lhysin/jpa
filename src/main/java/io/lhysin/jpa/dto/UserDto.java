package io.lhysin.jpa.dto;

import java.time.LocalDateTime;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class UserDto {
    private String name;
    private String email;
    private Integer loginCount;
    private LocalDateTime lastLoginAt;
    private Collection<OrderDto> orders;
}
