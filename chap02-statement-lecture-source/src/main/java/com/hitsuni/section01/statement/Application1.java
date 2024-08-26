package com.hitsuni.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.hitsuni.common.JDBCTemplate.close;
import static com.hitsuni.common.JDBCTemplate.getConnection;

public class Application1 {
    public static void main(String[] args) {
        /* 트랜잭션 처리를 위한 DBMS 연동용 Connection 객체 생성 */
        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;

        try {
            // Statement : 쿼리를 운반하고 결과를 반환하는 객체
            stmt = con.createStatement();

            // ResultSet : Statement 객체를 통해 조회 처리된 결과를 다루는 객체
            rset = stmt.executeQuery("SELECT * FROM employee");

            while(rset.next()) { // 결과 행이 존재하는지 확인
                // rset 은 1행을 참조하고 있으므로 해당 행에서 필요한 컬럼을 컬럼을 getXXX 메소드로 타입을 맞춰서 꺼내올 수 있다.
                System.out.print(rset.getString("emp_name") + " ");
                System.out.println(rset.getInt("salary"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            /* 생성과 달리 역순으로 각 스트림을 닫는다. */
            close(rset);
            close(stmt);
            close(con);
        }
    }
}
