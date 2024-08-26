package com.hitsuni.section02.update;

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
            System.out.print("수정할 메뉴의 코드를 입력하세요 : ");
            int menuCode = Integer.parseInt(br.readLine());
            System.out.print("해당 메뉴의 수정할 이름을 입력하세요 : ");
            String menuName = br.readLine();
            System.out.print("해당 메뉴의 수정할 가격을 입력하세요 : ");
            int menuPrice = Integer.parseInt(br.readLine());

            Menu menu = new Menu(menuName, menuPrice, menuCode);

            MenuService menuService = new MenuService();
            menuService.updateMenu(menu);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
