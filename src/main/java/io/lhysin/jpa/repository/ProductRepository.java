package io.lhysin.jpa.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.lhysin.jpa.entity.Product;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    public Page<Product> findAll(Pageable pageable);

    public Optional<Product> findBySeq(Long seq);
}