package io.lhysin.jpa.rest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.lhysin.jpa.entity.Product;
import io.lhysin.jpa.service.ProductService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public Page<Product> findAll(Pageable pageable) {
        return productService.findAll(pageable);
    }

    @GetMapping("/{seq}")
    public Product findBySeq(@PathVariable("seq") Long seq) {
        return productService.findBySeq(seq);
    }

}
