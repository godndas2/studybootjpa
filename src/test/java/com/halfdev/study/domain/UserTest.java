package com.halfdev.study.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void addToUser() {
        User user = User.builder()
                .name("halfdev")
                .password("1111")
                .email("halfdev@gmail.com")
                .build();
        userRepository.save(user);

        List<User> list = userRepository.findAll();
        User tester = list.get(0);
        assertThat(tester.getName(), is("halfdev"));
        assertThat(tester.getPassword(), is("1111"));
        assertThat(tester.getEmail(), is("halfdev@gmail.com"));
    }
}
