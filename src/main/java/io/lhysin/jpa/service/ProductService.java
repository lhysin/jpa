package io.lhysin.jpa.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.lhysin.jpa.entity.Product;
import io.lhysin.jpa.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Page<Product> findAll(Pageable pageable) {

        return productRepository.findAll(pageable);
    }

    public Product findBySeq(Long seq) {
        return productRepository.findBySeq(seq).orElseThrow(() -> new EntityNotFoundException());
    }

}
