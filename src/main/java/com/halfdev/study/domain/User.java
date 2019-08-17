package com.halfdev.study.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private LocalDateTime createDate;

    /*
    *  Table은 @ManyToMany를 할 수 없다. 그래서 매핑 테이블을 중앙에 두고 사용한다. (Ex : A <-> center <-> B
    * */
    @ManyToMany // @OneToMany는 잘 안쓴다. 자식들을 한 번에 가져올 수 있기 때문에 위험함
    @JoinTable(name = "user_roles"
            , joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id")
            , inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;
}
