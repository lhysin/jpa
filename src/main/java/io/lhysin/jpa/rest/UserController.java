package io.lhysin.jpa.rest;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.lhysin.jpa.dto.UserDto;
import io.lhysin.jpa.entity.User;
import io.lhysin.jpa.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDto> findAll(Pageable pageable) {
        return userService.findAll(pageable);
    }

    @GetMapping("/{seq}")
    public UserDto findBySeq(@PathVariable("seq") Long seq) {
        return userService.findBySeq(seq);
    }

    @GetMapping("/origin/{seq}")
    public User findOriginBySeq(@PathVariable("seq") Long seq) {
        User user = userService.findOriginBySeq(seq);
        return user;
    }

}
