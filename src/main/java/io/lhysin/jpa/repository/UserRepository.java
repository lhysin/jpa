package io.lhysin.jpa.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.lhysin.jpa.entity.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    public Page<User> findAll(Pageable pageable);

    public Optional<User> findBySeq(Long seq);
}