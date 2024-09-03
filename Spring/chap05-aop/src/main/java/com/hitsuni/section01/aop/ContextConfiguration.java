package com.hitsuni.section01.aop;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass=true) // CGLib 방식을 통해 Proxy 사용
public class ContextConfiguration {

}
