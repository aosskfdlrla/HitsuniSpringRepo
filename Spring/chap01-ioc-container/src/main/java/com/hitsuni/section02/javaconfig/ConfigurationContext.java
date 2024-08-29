package com.hitsuni.section02.javaconfig;

import com.hitsuni.common.MemberDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* configuration 어노테이션을 붙이고 이름까지 붙임.
* 해당 클래스는 빈을 생성하는 설정 클래스임을 표시하는 것임.
*  */
@Configuration("configurationSection02")
public class ConfigurationContext {

    /* 반환 타입이 중요하다. - 내용은 XML 파일과 같음. 다만 자바코드를 썻을 뿐이다.
    * @Bean(이름) : 설정을 해주지 않으면 기본적으로 getMember 인 메소드의 이름으로 설정된다.
    * */
    @Bean(name="member")
    public MemberDTO getMember() {
        return new MemberDTO(1, "user01", "pass01", "이순신");
    }
}
