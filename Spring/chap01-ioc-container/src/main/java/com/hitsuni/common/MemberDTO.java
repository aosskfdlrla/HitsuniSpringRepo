package com.hitsuni.common;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class MemberDTO {
    private int sequence;
    private String id;
    private String pwd;
    private String name;
}
