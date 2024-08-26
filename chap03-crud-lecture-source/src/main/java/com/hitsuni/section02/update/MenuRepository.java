package com.hitsuni.section02.update;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static com.hitsuni.common.JDBCTemplate.close;

public class MenuRepository {
    public int updateMenu(Connection conn, Menu menu) {
        PreparedStatement ps = null;
        int result = 0;

        Properties props = new Properties();
        try {
            props.loadFromXML(new FileInputStream("src/main/java/com/hitsuni/section01/insert/mapper/menu-mapper.xml"));
            String sql = props.getProperty("updateMenu");

            ps = conn.prepareStatement(sql);
            ps.setString(1, menu.getMenuName());
            ps.setInt(2, menu.getMenuPrice());
            ps.setInt(3, menu.getMenuCode());

            result = ps.executeUpdate();

        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(ps);
        }

        return result;
    }
}