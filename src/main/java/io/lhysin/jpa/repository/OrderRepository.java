package io.lhysin.jpa.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.lhysin.jpa.entity.Order;

@Repository
public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {
    public Page<Order> findAll(Pageable pageable);

    public Optional<Order> findBySeq(Long seq);
}