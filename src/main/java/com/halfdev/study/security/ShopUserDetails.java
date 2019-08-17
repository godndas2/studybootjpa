package com.halfdev.study.security;

import com.halfdev.study.domain.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ShopUserDetails implements UserDetails {

    private String username;
    private String password;
    private List<GrantedAuthority> authorities;

    public ShopUserDetails(User user) {
        this.username = user.getName();
        this.password = user.getPassword();
        this.authorities = user.getRoles().stream()
                // map : 특정 조건에 해당하는 값으로 변환 ( 대,소문자로 변환하고싶을 때 )
                .map(role -> new SimpleGrantedAuthority("ROLE_"+role.getName()))
                // collect를 이용해서 결과를 return 받음. forEach로 바로 출력할 수도 있다.
                // user.getRoles().stream().map(role -> new SimpleGrantedAuthority("ROLE_"+role.getName()).forEach(e -> System.out.println(e));
                .collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
