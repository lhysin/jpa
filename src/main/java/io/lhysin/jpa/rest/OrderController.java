package io.lhysin.jpa.rest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.lhysin.jpa.entity.Order;
import io.lhysin.jpa.service.OrderService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public Page<Order> findAll(Pageable pageable) {
        return orderService.findAll(pageable);
    }

    @GetMapping("/{seq}")
    public Order findBySeq(@PathVariable("seq") Long seq) {
        return orderService.findBySeq(seq);
    }

}
