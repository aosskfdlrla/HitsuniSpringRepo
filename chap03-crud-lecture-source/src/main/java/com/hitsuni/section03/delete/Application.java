package com.hitsuni.section03.delete;

import com.hitsuni.section03.delete.Menu;
import com.hitsuni.section03.delete.MenuService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

import static com.hitsuni.common.JDBCTemplate.getConnection;

public class Application {
    public static void main(String[] args) {
        Connection con = getConnection();
        PreparedStatement ps = null;

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("삭제할 메뉴의 코드를 입력하세요 : ");
            int menuCode = Integer.parseInt(br.readLine());

            Menu menu = new Menu(menuCode);

            MenuService menuService = new MenuService();
            menuService.updateMenu(menu);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
