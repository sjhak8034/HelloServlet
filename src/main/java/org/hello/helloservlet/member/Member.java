package org.hello.helloservlet.member;

import lombok.Data;
import lombok.Getter;

@Data
public class Member {
    private Long id; // 회원 ID
    private String username; // 회원 이름
    private int age; // 회원 나이

    public Member() {
    }

    public Member(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
