package io.lhysin.jpa.dto;

import java.time.LocalDateTime;

import io.lhysin.jpa.enums.OrderState;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class OrderDto {
    private Long seq;
    private Long userSeq;
    private Long productSeq;
    private Long reviewSeq;
    private OrderState state;
    private String requestMsg;
    private String rejectMsg;
    private LocalDateTime completedAt;
    private LocalDateTime rejectedAt;
    private UserDto user;

}
