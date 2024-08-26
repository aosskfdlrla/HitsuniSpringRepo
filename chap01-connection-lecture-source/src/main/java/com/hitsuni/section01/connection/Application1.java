package com.hitsuni.section01.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application1 {
    public static void main(String[] args) {
        Connection con = null;

        try {
            // 문자열로 작성 된 class 명칭이 잘못 되었을 경우 ClassNotFoundException 이 발생할 수 있으므로
            // Exception handling 한다.
            Class.forName("org.mariadb.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mariadb://localhost:3307/employee", "admin", "12345");

            System.out.println("con = " + con);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
