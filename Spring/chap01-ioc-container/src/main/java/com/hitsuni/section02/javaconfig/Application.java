package com.hitsuni.section02.javaconfig;

import com.hitsuni.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Member;

public class Application {
    public static void main(String[] args) {
        /* IoC 컨테이너가 이렇게 설정 정보를 가지게 되면 그 설정 정보에 따라서 객체를 생성한다. */
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationContext.class);

        /* 객체가 잘 생성되었는지 확인. */
        MemberDTO member = context.getBean("member", MemberDTO.class);
        System.out.println(member);
    }
}
