package io.lhysin.jpa.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.lhysin.jpa.dto.UserDto;
import io.lhysin.jpa.entity.User;
import io.lhysin.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public List<UserDto> findAll(Pageable pageable) {

        //@formatter:off
        return userRepository.findAll(pageable)
            .stream()
            .map(user -> modelMapper.map(user, UserDto.class))
            .collect(Collectors.toList());
        //@formatter:on
    }

    public UserDto findBySeq(Long seq) {
        //@formatter:off
        return userRepository.findBySeq(seq)
            .map(user -> modelMapper.map(user, UserDto.class))
            .orElseThrow(() -> new EntityNotFoundException());
        //@formatter:on
    }

    public User findOriginBySeq(Long seq) {
        return userRepository.findBySeq(seq).orElseThrow(() -> new EntityNotFoundException());
    }

}
