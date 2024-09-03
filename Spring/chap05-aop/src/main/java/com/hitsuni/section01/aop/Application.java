package com.hitsuni.section01.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext("com.hitsuni.section01.aop");
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        System.out.println("========== selectMembers ============");
        /* 메인기능이 호출 되기 전에 호출됨 */
        System.out.println(memberService.selectMembers());
        System.out.println("========== selectMember ============");
        System.out.println(memberService.selectMember(1L));
    }
}
