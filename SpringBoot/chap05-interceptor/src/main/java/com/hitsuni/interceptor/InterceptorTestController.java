package com.hitsuni.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InterceptorTestController {

    /* 요청이 들어오면
    * DispatcherServlet -> HandlerMapping -> | 이 사이를 가로 채는 Interceptor  | -> controller
    * */
    @GetMapping("/stopwatch")
    public String stopwatch() throws InterruptedException {
        System.out.println("핸들러 메소드 호출함");
        Thread.sleep(1000);
        return "result";
    }
}
