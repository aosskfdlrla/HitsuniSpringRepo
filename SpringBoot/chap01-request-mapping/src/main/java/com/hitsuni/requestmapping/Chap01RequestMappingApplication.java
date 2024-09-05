package com.hitsuni.requestmapping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* application.properties 를 읽어들여서 설정대로 프로젝트 수행을 한다.
* application.yml, yaml 둘 다 사용가능
* */
@SpringBootApplication
public class Chap01RequestMappingApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chap01RequestMappingApplication.class, args);
    }

}
