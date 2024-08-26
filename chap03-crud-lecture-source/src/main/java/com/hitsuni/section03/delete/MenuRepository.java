package com.hitsuni.section03.delete;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class MenuRepository {
    public int deleteMenu(Connection conn, Menu menu) {
        PreparedStatement ps = null;
        int result = 0;

        Properties props = new Properties();
        try {
            props.loadFromXML(new FileInputStream("src/main/java/com/hitsuni/section01/insert/mapper/menu-mapper.xml"));
            String sql = props.getProperty("deleteMenu");

            ps = conn.prepareStatement(sql);
            ps.setInt(1, menu.getMenuCode());

            result = ps.executeUpdate();

        } catch(IOException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }
}