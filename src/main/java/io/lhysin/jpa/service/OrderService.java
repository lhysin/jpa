package io.lhysin.jpa.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.lhysin.jpa.entity.Order;
import io.lhysin.jpa.repository.OrderRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Page<Order> findAll(Pageable pageable) {

        return orderRepository.findAll(pageable);
    }

    public Order findBySeq(Long seq) {
        return orderRepository.findBySeq(seq).orElseThrow(() -> new EntityNotFoundException());
    }

}
