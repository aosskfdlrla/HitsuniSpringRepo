package com.hitsuni.section01.insert;

import org.checkerframework.checker.units.qual.C;

import java.sql.Connection;

import static com.hitsuni.common.JDBCTemplate.*;

/* Service 계층은 Connection 객체 생성 및 소명(close), 비즈니스 로직, 트랜잭션(commit or rollback) 처리
* 트랜잭션 단위를 관리하는 계층, 비즈니스 로직을 관리하는 곳.
* */
public class MenuService {

    public void registerMenu(Menu menu) {
        Connection con = getConnection();

        MenuRepository menuRepository = new MenuRepository();
        int result = menuRepository.insertMenu(con, menu);

        if(result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);
    }
}
