package com.halfdev.study.security;

import com.halfdev.study.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class ShopUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return userRepository.findByName(name)
                // :: -> parameter가 없는 public method를 static method 호출하듯이 작성 가능
                .map(ShopUserDetails::new)
                // orElseThrow : Exception을 던짐
                // IllegalArgumentException : 메소드가 잘못되었거나 부적합한 인수를 전달했음을 나타내기 위해 던져집니다.
                .orElseThrow(IllegalArgumentException::new);
    }
}
