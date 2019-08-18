//package com.halfdev.study.domain;
//
//import com.halfdev.study.repository.MemberRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Slf4j
//public class MemberTest {
//
//    @Autowired
//    MemberRepository memberRepository;
//
//    @Test
//    public void insertTest() {
//        for(int i=0; i<100; i++) {
//            Member member = new Member();
//            member.setUid("user" + i);
//            member.setUpw("pw" + i);
//            member.setUemail("halfdev@" + i);
//            MemberRole role = new MemberRole();
//            if(i <= 80) {
//                role.setRoleName("BASIC");
//            }else if(i <= 90) {
//                role.setRoleName("MANAGER");
//            }else {
//                role.setRoleName("ADMIN");
//            }
//            member.setRoles(Arrays.asList(role));
//            memberRepository.save(member);
//        }
//
//    }
//}
