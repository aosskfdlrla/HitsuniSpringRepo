package com.hitsuni.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    /* 의존성 주입이 일어날 수 있도록 해주어야 함. */
    private final StopWatchInterceptor stopWatchInterceptor;

    public WebConfiguration(StopWatchInterceptor stopWatchInterceptor) {
        this.stopWatchInterceptor = stopWatchInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(stopWatchInterceptor).addPathPatterns("/stopwatch");
    }
}
