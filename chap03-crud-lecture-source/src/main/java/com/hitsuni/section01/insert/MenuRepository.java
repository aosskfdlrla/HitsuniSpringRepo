package com.hitsuni.section01.insert;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static com.hitsuni.common.JDBCTemplate.close;

/* DBMS 를 통해서 수행하는 CRUD 작업 단위 메소드 */
public class MenuRepository {
    public int insertMenu(Connection con, Menu menu) {
        PreparedStatement ps = null;

        int result = 0;

        Properties props = new Properties();
        try {
            props.loadFromXML(new FileInputStream("src/main/java/com/hitsuni/section01/insert/mapper/menu-mapper.xml"));
            String sql = props.getProperty("insertMenu");

            ps = con.prepareStatement(sql);
            ps.setString(1, menu.getMenuName());
            ps.setInt(2, menu.getMenuPrice());
            ps.setInt(3, menu.getCategoryCode());
            ps.setString(4, menu.getOrderAbleStatus());

            result = ps.executeUpdate();

        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(ps);
        }

        return result;
    }
}
