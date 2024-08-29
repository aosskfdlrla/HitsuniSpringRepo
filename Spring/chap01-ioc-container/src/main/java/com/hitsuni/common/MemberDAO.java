package com.hitsuni.common;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/* 컴포넌트 스캔을 통해서 빈으로 등록 될 수 있도록 함.
* IoC 가 스캔을 해서 Component 가 달려 있으믄 알아서 Bean 에 등록한다.
* 즉, 스캔해서 Component 가 있다면 Bean 으로 등록 해달라는 뜻.
* */
@Component
public class MemberDAO {

    private final Map<Integer, MemberDTO> memberMap;

    public MemberDAO() {
        memberMap = new HashMap<>();
        memberMap.put(1, new MemberDTO(1, "user01", "pass01", "홍길동"));
        memberMap.put(2, new MemberDTO(2, "user02", "pass02", "유관순"));
    }

    public MemberDTO selectMember(int sequence) {
        return memberMap.get(sequence);
    }

    public boolean insertMember(MemberDTO member) {
        int before = memberMap.size();
        memberMap.put(member.getSequence(), member);
        int after = memberMap.size();
        return after > before;
    }

}
