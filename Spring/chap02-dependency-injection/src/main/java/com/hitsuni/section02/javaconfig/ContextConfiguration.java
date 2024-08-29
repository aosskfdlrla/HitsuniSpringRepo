package com.hitsuni.section02.javaconfig;

import com.hitsuni.common.Account;
import com.hitsuni.common.MemberDTO;
import com.hitsuni.common.PersonalAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {

    @Bean
    public Account accountGenerator() {
        return new PersonalAccount(20, "110-234-567890");
    }

    /* bean 등록에 사용 된 메소드를 호출하여 의존성 주입을 처리할 수 있다. */
    @Bean
    public MemberDTO memberGenerator() {
        /* 1. 생성자 주입 */
        return new MemberDTO(1, "홍길동", "010-2342-9870", "hong@gmail.com", accountGenerator());

        /* 2. setter 주입 */
//        MemberDTO member = new MemberDTO();
//        member.setSequence(1);
//        member.setName("홍길동");
//        member.setPhone("010-9870-0920");
//        member.setEmail("hong@gmail.com");
//        member.setPersonalAccount(accountGenerator());
//        return member;
    }
}
