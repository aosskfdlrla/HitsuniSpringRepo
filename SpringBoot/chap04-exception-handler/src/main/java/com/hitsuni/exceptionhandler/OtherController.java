package com.hitsuni.exceptionhandler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OtherController {
    @GetMapping("/other-controller-null")
    public String nullPointerExceptionTest() {
        String str = null;
        System.out.println(str.charAt(0));  // 의도적인 NullPointerException 발생
        return "/";
    }

    @GetMapping("/other-controller-user")
    public String userExceptionTest() throws MemberRegisterException {
        boolean check = true;
        if(check) throw new MemberRegisterException("당신 같은 사람은 회원으로 받을 수 없습니다.");
        return "/";
    }

    @GetMapping("/other-controller-array")
    public String arrayExceptionTest() {
        double[] array = new double[0];
        System.out.println(array[0]);
        return "/";
    }
}
