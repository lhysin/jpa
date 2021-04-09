package io.lhysin.jpa.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.lhysin.jpa.entity.Review;
import io.lhysin.jpa.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public Page<Review> findAll(Pageable pageable) {

        return reviewRepository.findAll(pageable);
    }

    public Review findBySeq(Long seq) {
        return reviewRepository.findBySeq(seq).orElseThrow(() -> new EntityNotFoundException());
    }

}
