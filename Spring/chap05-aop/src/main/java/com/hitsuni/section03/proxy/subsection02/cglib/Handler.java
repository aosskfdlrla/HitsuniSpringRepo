package com.hitsuni.section03.proxy.subsection02.cglib;

import com.hitsuni.section03.proxy.common.HitsuniStudent;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

public class Handler implements InvocationHandler {

    /* Target Object 로 class 타입 사용 가능 */
    private final HitsuniStudent hitsuniStudent;
    public Handler(HitsuniStudent hitsuniStudent) {
        this.hitsuniStudent = hitsuniStudent;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
