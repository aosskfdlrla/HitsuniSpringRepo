package com.hitsuni.section03.annotationconfig.subsection01.java;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/* 이 클래스는 설정 파일 클래스인데 컴포넌트를 스캔을 하겠다.
* basePackages 을 기준으로 스캔을 진행한다.
* basePackages 를 따로 정해주지 않는다면 현재 패키지 기준으로 스캔이 수행된다.
* @Configuration("이름설정") 이름 설정을 해주지 않으면 클래스명을 default 로 잡는다.
*  */
@Configuration
@ComponentScan(basePackages = "com.hitsuni")
public class ConfigurationContext {

}
