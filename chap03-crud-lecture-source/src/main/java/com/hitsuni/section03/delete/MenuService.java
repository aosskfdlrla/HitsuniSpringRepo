package com.hitsuni.section03.delete;

import com.hitsuni.section03.delete.Menu;
import com.hitsuni.section03.delete.MenuRepository;

import java.sql.Connection;

import static com.hitsuni.common.JDBCTemplate.*;
import static com.hitsuni.common.JDBCTemplate.close;

public class MenuService {
    public void updateMenu(Menu menu) {
        Connection con = getConnection();

        MenuRepository repository = new MenuRepository();
        int result = repository.deleteMenu(con, menu);

        if(result > 0)
            commit(con);
        else
            rollback(con);

        close(con);
    }
}
