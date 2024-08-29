package com.hitsuni.section01.xmlconfig;

import com.hitsuni.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        /* xml 파일을 통해서 configuration Metadata 를 통해서 등록된 Bean 이 있는지 확인하고 객체를 가져오게 됨. */
        ApplicationContext applicationContext =
                new GenericXmlApplicationContext("section01/xmlconfig/spring-context.xml");

        /* 다음의 작업을 통해서 IoC 가 POJO(Plain Old Java Object) 를 통해서 객체를 생성했음을 알 수 있다. */
        MemberDTO member1 = (MemberDTO)applicationContext.getBean("member"); // bean id 로 가져오기
        MemberDTO member2 = applicationContext.getBean(MemberDTO.class);           // 클래스 메타 정보로 가져오기
        MemberDTO member3 = applicationContext.getBean("member", MemberDTO.class);

        System.out.println(member3);

    }
}
