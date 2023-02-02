package com.test.project;

import com.test.project.entity.TbUser;
import com.test.project.repository.TbUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final TbUserRepository userRepository;

    @PostMapping("/users")
    public ResponseEntity<Long> createUser(@RequestBody UserParam param) {
        log.info(param.toString());
        TbUser user = new TbUser();
        user.setUserId(param.getUserId());
        user.setUserName(param.getUserName());

        userRepository.save(user);

        return new ResponseEntity<Long>(user.getUserCode(), HttpStatus.CREATED);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<TbUser> userList(@PathVariable Long id) {
        Optional<TbUser> user = userRepository.findById(id);
        if (user.isPresent()) {
            return new ResponseEntity<TbUser>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<TbUser>(HttpStatus.NOT_FOUND);
        }
    }
}
