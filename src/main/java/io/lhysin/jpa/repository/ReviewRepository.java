package io.lhysin.jpa.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.lhysin.jpa.entity.Review;

@Repository
public interface ReviewRepository extends PagingAndSortingRepository<Review, Long> {
    public Page<Review> findAll(Pageable pageable);

    public Optional<Review> findBySeq(Long seq);
}