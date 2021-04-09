package io.lhysin.jpa.rest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.lhysin.jpa.entity.Review;
import io.lhysin.jpa.service.ReviewService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    public Page<Review> findAll(Pageable pageable) {
        return reviewService.findAll(pageable);
    }

    @GetMapping("/{seq}")
    public Review findBySeq(@PathVariable("seq") Long seq) {
        return reviewService.findBySeq(seq);
    }

}
